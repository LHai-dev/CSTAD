package com.job_room.annoouncement_service.rest.restcontroller;

import com.job_room.annoouncement_service.components.DateValidator;
import com.job_room.annoouncement_service.components.DateValidatorUsingDateFormat;
import com.job_room.annoouncement_service.model.announcement.AnnouncementDto;
import com.job_room.annoouncement_service.model.announcement.AnnouncementResponse;
import com.job_room.annoouncement_service.model.candidate.*;
import com.job_room.annoouncement_service.rest.message.*;
import com.job_room.annoouncement_service.service.AnnouncementService;
import com.job_room.annoouncement_service.service.CandidateService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class CandidateController {
    private MessageProperties messageProperties;

    private CandidateService candidateService;
    private AnnouncementService announcementService;
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setAnnouncementService(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @Autowired
    public void setCandidateService(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public void setMessageProperties(MessageProperties messageProperties) {
        this.messageProperties = messageProperties;
    }

    public CandidateController() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    //TODO: Exception =========================================================
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {

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

        response.setMessage(messageProperties.insertError("Candidate"));
        response.setError(errors);
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setTime(new Timestamp(System.currentTimeMillis()));

        return ResponseEntity.ok(response);
    }

    //TODO: Insert Candidate =========================================================
    @PostMapping("/candidates")
    public ResponseEntity<BaseApiResponse<CandidateResponse>> insertCandidate(
            @Valid @RequestBody CandidateRequest candidateRequest) throws ParseException {

        BaseApiResponse<CandidateResponse> response = new BaseApiResponse<>();
        CandidateDto candidateDto = modelMapper.map(candidateRequest, CandidateDto.class);
        CandidateDto result = candidateService.insert(candidateDto);
        CandidateResponse candidateResponse = null;

        if(result == null){
            response.setMessage(messageProperties.insertError("candidate (announcement or employee not found)"));
            response.setStatus(HttpStatus.NO_CONTENT);
        }else{

            candidateResponse = modelMapper.map(result, CandidateResponse.class);
            response.setMessage(messageProperties.inserted("Candidate"));
            candidateResponse.setId(result.getId());
        }


        response.setData(candidateResponse);
        response.setStatus(HttpStatus.CREATED);

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    //TODO: Delete Candidate =========================================================
    @DeleteMapping("/candidates/{id}")
    private ResponseEntity<BaseApiResponse<CandidateResponse>> deleteCandidate(@Valid @PathVariable("id") int id) {

        BaseApiResponse<CandidateResponse> response = new BaseApiResponse<>();

        CandidateDto candidateDto = candidateService.delete(id);
        CandidateResponse candidateResponse;

        if (candidateDto == null) {

            response.setMessage(messageProperties.deletedError("candidate", "candidate"));
            response.setStatus(HttpStatus.NO_CONTENT);

        } else {
            candidateResponse = modelMapper.map(candidateDto, CandidateResponse.class);
            response.setMessage(messageProperties.deleted("Candidate"));
            response.setData(candidateResponse);
            response.setStatus(HttpStatus.OK);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    //TODO: Select Candidate by id =========================================================
    @GetMapping("/candidates/{id}")
    public ResponseEntity<BaseApiResponse<CandidateEmployeeAnnouncementRes>> findCandidateById(@PathVariable int id) {

        BaseApiResponse<CandidateEmployeeAnnouncementRes> baseApiResponse = new BaseApiResponse<>();

        CandidateDto candidateDto = candidateService.selectById(id);
        AnnouncementDto announcementDto;
        CandidateEmployee candidateEmployee;
        AnnouncementResponse announcementResponse;
        if (candidateDto == null) {

            baseApiResponse.setMessage(messageProperties.hasNoRecord("candidate"));
            baseApiResponse.setStatus(HttpStatus.NO_CONTENT);
        } else {
            ///TODO Consume Announcement By Id
            announcementDto = announcementService.selectById(candidateDto.getAnnouncementId());
            //TODO Consume Employee By Id
            candidateEmployee = candidateService.selectEmployeeById(candidateDto.getEmployeeId());

            ///TODO map candidateDto to CandidateEmployeeAnnouncementRes if Not Null
            CandidateEmployeeAnnouncementRes response = modelMapper.map(candidateDto, CandidateEmployeeAnnouncementRes.class);
            if (announcementDto != null && candidateEmployee != null) {

                announcementResponse = modelMapper.map(announcementDto, AnnouncementResponse.class);
                response.setAnnouncement(announcementResponse);
                response.setEmployee(candidateEmployee);

            } else if (announcementDto == null && candidateEmployee != null) {
                response.setAnnouncement(null);
                response.setEmployee(candidateEmployee);

            } else if (candidateEmployee == null && announcementDto != null) {
                announcementResponse = modelMapper.map(announcementDto, AnnouncementResponse.class);
                response.setEmployee(null);
                response.setAnnouncement(announcementResponse);
            } else {

                response.setEmployee(null);
                response.setAnnouncement(null);
            }


            baseApiResponse.setMessage(messageProperties.selectedOne("candidate"));
            baseApiResponse.setData(response);
            baseApiResponse.setStatus(HttpStatus.OK);
        }

        baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(baseApiResponse);
    }

    //TODO: Select All Candidate =========================================================
    @GetMapping("/candidates")
    public ResponseEntity<Object> selectAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize) {

        Pageable pageable = PageRequest.of(page, pageSize);
        Page<CandidateDto> candidatePage = candidateService.selectAll(pageable);
        return filter(candidatePage);
    }

    //TODO: Filter Candidate By Announcement =========================================================
    @GetMapping("/candidates/announcement/{announcementId}")
    public ResponseEntity<Object> filterByAnnouncementId(
            @PathVariable int announcementId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<CandidateDto> candidatePage = candidateService.filterCandidateByAnnouncementId(announcementId, pageable);
        return filter(candidatePage);
    }

    @GetMapping("/candidates/filterDate")
    public ResponseEntity<Object> filterByDate(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "2000-01-31") String startDate,
            @RequestParam(defaultValue = "2000-01-31") String endDate
    ) {
        BaseApiResponse baseApiResponse = new BaseApiResponse();
        try {
            DateValidator dateValidator=new DateValidatorUsingDateFormat("yyyy-MM-dd");
            String stDate = startDate;
            String spDate = endDate;
            if(dateValidator.isValid(startDate) && dateValidator.isValid(endDate)){
                SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = formatter.parse(stDate);
                Date date2 = formatter.parse(spDate);
                Pageable pageable = PageRequest.of(page, pageSize);
                Page<CandidateDto> candidatePage = candidateService.findAllByAppliesDateBetween(date1, date2, pageable);
                return filter(candidatePage);
            }else{
                baseApiResponse.setData(null);
                baseApiResponse.setMessage("Please input with date format (yyyy-MM-dd)");
                baseApiResponse.setStatus(HttpStatus.BAD_REQUEST);
                baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
                return ResponseEntity.ok(baseApiResponse);

            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            baseApiResponse.setData(null);
            baseApiResponse.setMessage(e.getMessage());
            baseApiResponse.setStatus(HttpStatus.BAD_REQUEST);
            baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
            return ResponseEntity.ok(baseApiResponse);
        }

    }



    ///TODO Function Filter
    public ResponseEntity<Object> filter(Page<CandidateDto> candidates) {

        List<CandidateDto> candidateDtoList = candidates.getContent();

        List<CandidateEmployeeAnnouncementRes> candidateResponses = new ArrayList<>();
        AnnouncementResponse announcementResponse;
        BaseApiResponseWithPagination<List<CandidateEmployeeAnnouncementRes>> baseApiResponseWithPagination = new BaseApiResponseWithPagination<>();

        Pagination pagination = new Pagination();
        ///TODO check of Candidates List is Empty
        if (candidateDtoList.size() <= 0) {

            baseApiResponseWithPagination.setData(candidateResponses);
            baseApiResponseWithPagination.setMessage(messageProperties.hasNoRecords("candidates"));
            ///TODO Set Pagination
            pagination.setCurrentPage(candidates.getNumber());
            pagination.setPageSize(candidates.getSize());
            pagination.setTotalItems(candidates.getTotalElements());
            pagination.setTotalPages(candidates.getTotalPages());

            baseApiResponseWithPagination.setPagination(pagination);
            baseApiResponseWithPagination.setStatus(HttpStatus.NO_CONTENT);
            baseApiResponseWithPagination.setTime(new Timestamp(System.currentTimeMillis()));
            return ResponseEntity.ok(baseApiResponseWithPagination);
        } else {
            for (int i = 0; i < candidateDtoList.size(); i++) {
                ///TODO consume Announcement
                AnnouncementDto announcementDto = announcementService.selectById(candidateDtoList.get(i).getAnnouncementId());
                ///TODO consume Employee
                CandidateEmployee candidateEmployee = candidateService.selectEmployeeById(candidateDtoList.get(i).getEmployeeId());
                ///TODO check if announcement not null we map announcementDto to announcementResponse and add to candidateResponse
                if (announcementDto != null && candidateEmployee != null) {

                    announcementResponse = modelMapper.map(announcementDto, AnnouncementResponse.class);
                    ///TODO map candidateDto List to candidateResponse List
                    candidateResponses.add(modelMapper.map(candidateDtoList.get(i), CandidateEmployeeAnnouncementRes.class));
                    ///TODO add AnnouncementResponse to CandidateResponse
                    candidateResponses.get(i).setAnnouncement(announcementResponse);
                    candidateResponses.get(i).setEmployee(candidateEmployee);

                } else if (announcementDto == null && candidateEmployee != null) {

                    candidateResponses.add(modelMapper.map(candidateDtoList.get(i), CandidateEmployeeAnnouncementRes.class));
                    candidateResponses.get(i).setAnnouncement(null);
                    candidateResponses.get(i).setEmployee(candidateEmployee);

                } else if (candidateEmployee == null && announcementDto != null) {
                    announcementResponse = modelMapper.map(announcementDto, AnnouncementResponse.class);
                    candidateResponses.add(modelMapper.map(candidateDtoList.get(i), CandidateEmployeeAnnouncementRes.class));
                    candidateResponses.get(i).setEmployee(null);
                    candidateResponses.get(i).setAnnouncement(announcementResponse);
                } else {

                    candidateResponses.add(modelMapper.map(candidateDtoList.get(i), CandidateEmployeeAnnouncementRes.class));
                    candidateResponses.get(i).setEmployee(null);
                    candidateResponses.get(i).setAnnouncement(null);
                }

            }
            baseApiResponseWithPagination.setData(candidateResponses);
            baseApiResponseWithPagination.setMessage(messageProperties.selected("candidates"));
            ///TODO Set Pagination
            pagination.setCurrentPage(candidates.getNumber());
            pagination.setPageSize(candidates.getSize());
            pagination.setTotalItems(candidates.getTotalElements());
            pagination.setTotalPages(candidates.getTotalPages());

            baseApiResponseWithPagination.setPagination(pagination);
            baseApiResponseWithPagination.setStatus(HttpStatus.FOUND);
            baseApiResponseWithPagination.setTime(new Timestamp(System.currentTimeMillis()));
            return ResponseEntity.ok(baseApiResponseWithPagination);
        }

    }
}
