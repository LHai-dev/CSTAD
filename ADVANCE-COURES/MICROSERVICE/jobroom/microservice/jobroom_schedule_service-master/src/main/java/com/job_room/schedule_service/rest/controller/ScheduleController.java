package com.job_room.schedule_service.rest.controller;

import com.job_room.schedule_service.model.Dto.ScheduleDto;
import com.job_room.schedule_service.model.reponse.SchedulePostResponse;
import com.job_room.schedule_service.model.reponse.SelectScheduleResponse;
import com.job_room.schedule_service.model.reponse.ScheduleCandidate;
import com.job_room.schedule_service.model.reponse.ScheduleResponse;
import com.job_room.schedule_service.model.request.CandidateIdRequest;
import com.job_room.schedule_service.model.request.SchedulePostRequest;
import com.job_room.schedule_service.rest.message.*;
import com.job_room.schedule_service.service.ScheduleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class ScheduleController {
    private ScheduleService scheduleService;
    private MessageProperties messageProperties;
    @Autowired
    public void setScheduleService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
    @Autowired
    public void setMessageProperties(MessageProperties messageProperties) {
        this.messageProperties = messageProperties;
    }
    //TODO: Exception =========================================================
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex){

        ErrorResponse response = new ErrorResponse();
        List<Object> errors = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {

            Map<String, String> objectError = new HashMap<>();
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            objectError.put("field", fieldName);
            objectError.put("message", errorMessage);
            errors.add(objectError);
        });

        response.setMessage(messageProperties.insertError("Schedule"));
        response.setError(errors);
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setTime(new Timestamp(System.currentTimeMillis()));

        return ResponseEntity.ok(response);
    }

    //TODO Insert Schedule =========================================================
    @PostMapping("/schedules")
    public ResponseEntity<BaseApiResponse<List<SchedulePostResponse>>> insertSchedule(@Valid @RequestBody SchedulePostRequest schedulePostRequest
                                ,String email,String password) throws MessagingException {

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        BaseApiResponse<List<SchedulePostResponse>> baseApiResponse=new BaseApiResponse<>();
        List<SchedulePostResponse> scheduleResponseList = new ArrayList<>();

        ScheduleDto scheduleDto = new ScheduleDto();
        SchedulePostResponse scheduleResponse;
        List<String> candidateEmails = new ArrayList<>();
        ScheduleCandidate scheduleCandidate;

        for (CandidateIdRequest candidateId:schedulePostRequest.getCandidateIdRequest()) {

            scheduleCandidate= scheduleService.selectCandidateById(candidateId.getId());

            if(scheduleCandidate==null){

                baseApiResponse.setMessage("Cannot find candidate");
                baseApiResponse.setStatus(HttpStatus.NO_CONTENT);
                baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
                return ResponseEntity.ok(baseApiResponse);
            }

            candidateEmails.add(scheduleCandidate.getEmployee().getEmail());
        }

        for (int i=0;i<schedulePostRequest.getCandidateIdRequest().length;i++) {

            scheduleDto.setCandidateId(schedulePostRequest.getCandidateIdRequest()[i].getId());
            scheduleDto.setHrId(schedulePostRequest.getHrId());
            scheduleDto.setMeetingDate(schedulePostRequest.getMeetingDate());
            scheduleDto.setPosition(schedulePostRequest.getPosition());
            scheduleDto.setRemark(schedulePostRequest.getRemark());

            scheduleResponse=modelMapper.map(scheduleService.insert(scheduleDto),SchedulePostResponse.class);
            scheduleService.notifyCandidate(candidateEmails.get(0),email,password,schedulePostRequest.getEmailContent());

            scheduleResponseList.add(scheduleResponse);
        }

        baseApiResponse.setData(scheduleResponseList);
        baseApiResponse.setMessage(messageProperties.inserted("Schedule"));
        baseApiResponse.setStatus(HttpStatus.CREATED);
        baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(baseApiResponse);

    }
    //TODO Select ALl Schedule =========================================================
    @GetMapping("/schedules/{id}")
    public ResponseEntity<Object> findAllByHr(
            @PathVariable int id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10")int pageSize){

        BaseApiResponseWithPagination<List<SelectScheduleResponse>> baseApiResponseWithPagination = new BaseApiResponseWithPagination<>();

        Page<ScheduleDto> schedulePage=scheduleService.selectAllByStatus(id,page,pageSize);
        Pagination pagination = new Pagination();
        List<SelectScheduleResponse> scheduleResponseList=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();

        ///TODO Set Pagination
        pagination.setCurrentPage(schedulePage.getNumber());
        pagination.setTotalItems(schedulePage.getTotalElements());
        pagination.setTotalPages(schedulePage.getTotalPages());
        pagination.setPageSize(schedulePage.getSize());

        if(schedulePage.getContent().isEmpty()){

            baseApiResponseWithPagination.setTime(new Timestamp(System.currentTimeMillis()));
            baseApiResponseWithPagination.setStatus(HttpStatus.NO_CONTENT);
            baseApiResponseWithPagination.setMessage(messageProperties.hasNoRecords("Schedule"));
            baseApiResponseWithPagination.setData(new ArrayList<>());
            baseApiResponseWithPagination.setPagination(pagination);

            return ResponseEntity.ok(baseApiResponseWithPagination);

        }else{
           for(int i=0;i<schedulePage.getContent().size();i++){

               ///TODO Consume Candidate
               ScheduleCandidate scheduleCandidate=scheduleService.selectCandidateById(schedulePage.getContent().get(i).getCandidateId());;
               scheduleResponseList.add(modelMapper.map(schedulePage.getContent().get(i), SelectScheduleResponse.class));
               scheduleResponseList.get(i).setCandidate(scheduleCandidate);

           }

            baseApiResponseWithPagination.setData(scheduleResponseList);
            baseApiResponseWithPagination.setMessage(messageProperties.selected("Schedule"));
            baseApiResponseWithPagination.setPagination(pagination);
            baseApiResponseWithPagination.setStatus(HttpStatus.FOUND);
            baseApiResponseWithPagination.setTime(new Timestamp(System.currentTimeMillis()));

            return ResponseEntity.ok(baseApiResponseWithPagination);
        }
    }
    //TODO delete Schedule =========================================================
    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<Object> deleteSchedule(@PathVariable int id){

        ScheduleDto scheduleDto=scheduleService.delete(id);

        BaseApiResponse<ScheduleResponse> response=new BaseApiResponse<>();
        ModelMapper modelMapper=new ModelMapper();
        ScheduleResponse scheduleResponse;
        ErrorMessage errorMessage=new ErrorMessage();

        if(scheduleDto!=null){

            scheduleResponse=modelMapper.map(scheduleDto,ScheduleResponse.class);
            response.setData(scheduleResponse);
            response.setMessage(messageProperties.deleted("Schedule"));
            response.setStatus(HttpStatus.OK);
            response.setTime(new Timestamp(System.currentTimeMillis()));

            return ResponseEntity.ok(response);

        }else {

            errorMessage.setMessage(messageProperties.deletedError("Schedule",String.valueOf(id)));
            errorMessage.setStatus(HttpStatus.NOT_FOUND);
            errorMessage.setTime(new Timestamp(System.currentTimeMillis()));

            return ResponseEntity.ok(errorMessage);
        }
    }
    //TODO Update Schedule =========================================================
    @PutMapping("/schedules/{id}")
    public ResponseEntity<Object> updateSchedule(@PathVariable int id,@RequestBody SchedulePostRequest schedulePostRequest
            ,String email,String password) throws MessagingException {

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        BaseApiResponse<List<SchedulePostResponse>> baseApiResponse=new BaseApiResponse<>();
        List<SchedulePostResponse> scheduleResponseList = new ArrayList<>();

        ScheduleDto scheduleDto = new ScheduleDto();
        SchedulePostResponse scheduleResponse;
        List<String> candidateEmails = new ArrayList<>();
        ScheduleCandidate scheduleCandidate;

        for (CandidateIdRequest candidateId:schedulePostRequest.getCandidateIdRequest()) {

            scheduleCandidate= scheduleService.selectCandidateById(candidateId.getId());

            if(scheduleCandidate==null){
                baseApiResponse.setMessage("Cannot find candidate");
                baseApiResponse.setStatus(HttpStatus.NO_CONTENT);
                baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
                return ResponseEntity.ok(baseApiResponse);
            }

            candidateEmails.add(scheduleCandidate.getEmployee().getEmail());
        }

        for (int i=0;i<schedulePostRequest.getCandidateIdRequest().length;i++) {

            scheduleDto.setCandidateId(schedulePostRequest.getCandidateIdRequest()[i].getId());
            scheduleDto.setHrId(schedulePostRequest.getHrId());
            scheduleDto.setMeetingDate(schedulePostRequest.getMeetingDate());
            scheduleDto.setPosition(schedulePostRequest.getPosition());
            scheduleDto.setRemark(schedulePostRequest.getRemark());

            scheduleResponse=modelMapper.map(scheduleService.insert(scheduleDto),SchedulePostResponse.class);
            scheduleService.notifyCandidate(candidateEmails.get(0),email,password,schedulePostRequest.getEmailContent());

            scheduleResponseList.add(scheduleResponse);
        }

        ErrorMessage errorMessage=new ErrorMessage();

        if(scheduleResponseList!=null){

            baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
            baseApiResponse.setData(scheduleResponseList);
            baseApiResponse.setStatus(HttpStatus.OK);
            baseApiResponse.setMessage(messageProperties.updated("Schedule"));

            return ResponseEntity.ok(baseApiResponse);

        }else{

            errorMessage.setTime(new Timestamp(System.currentTimeMillis()));
            errorMessage.setStatus(HttpStatus.NOT_FOUND);
            errorMessage.setMessage(messageProperties.updatedError("Schedule"));

            return ResponseEntity.ok(errorMessage);
        }

    }
}
