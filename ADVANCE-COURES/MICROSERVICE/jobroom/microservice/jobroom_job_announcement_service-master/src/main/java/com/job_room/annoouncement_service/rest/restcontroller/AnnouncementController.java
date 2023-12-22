package com.job_room.annoouncement_service.rest.restcontroller;

import com.job_room.annoouncement_service.components.CommonUtils;
import com.job_room.annoouncement_service.components.DateValidator;
import com.job_room.annoouncement_service.components.DateValidatorUsingDateFormat;
import com.job_room.annoouncement_service.model.announcement.AnnouncementDto;
import com.job_room.annoouncement_service.model.announcement.AnnouncementRequest;
import com.job_room.annoouncement_service.model.announcement.AnnouncementResponse;
import com.job_room.annoouncement_service.model.announcement.AnnouncementResponseWithCompany;
import com.job_room.annoouncement_service.model.consume_model.Company;
import com.job_room.annoouncement_service.rest.message.*;
import com.job_room.annoouncement_service.service.AnnouncementService;
import com.job_room.annoouncement_service.service.CandidateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class AnnouncementController {

    private AnnouncementService announcementService;

    private CandidateService candidateService;

    private MessageProperties messageProperties;

    private ModelMapper modelMapper = new ModelMapper();

    private CommonUtils util;

    @Autowired
    public void setUtil(CommonUtils util) {
        this.util = util;
    }


    @Autowired

    public void setMessageProperties(MessageProperties messageProperties) {
        this.messageProperties = messageProperties;
    }

    @Autowired
    public void setAnnouncementService(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @Autowired
    public void setCandidateService(CandidateService candidateService) {
        this.candidateService = candidateService;
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

        response.setMessage(messageProperties.insertError("Announcement"));
        response.setError(errors);
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setTime(new Timestamp(System.currentTimeMillis()));

        return ResponseEntity.ok(response);
    }

    //For admin

    //TODO: Select announcement by company id =========================================================
    @GetMapping("/announcements/company/{companyId}")
    public ResponseEntity<Object> selectByCompanyId(
            @PathVariable int companyId,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int pageSize,
            @RequestParam(defaultValue = "", required = false) String caption
    ) {

        BaseApiResponseWithPagination<List<AnnouncementResponse>> response = new BaseApiResponseWithPagination<>();
        Pageable pageable = PageRequest.of(page, pageSize);

        Page<AnnouncementDto> announcementWithPage = announcementService.selectAnnouncementsByCompany(companyId, caption, pageable);
        return listAnnouncement(announcementWithPage, response);

    }

    //TODO: Ban announcement =========================================================
    @PostMapping("/announcements/ban/{id}")
    public ResponseEntity<BaseApiResponse<AnnouncementResponse>> banAnnouncement(
            @PathVariable int id) {

        BaseApiResponse<AnnouncementResponse> response = new BaseApiResponse<>();

        AnnouncementDto announcementDto = announcementService.ban(id);
        if (announcementDto == null) {

            response.setMessage(messageProperties.hasNoRecord("announcement"));
            response.setStatus(HttpStatus.NO_CONTENT);
            response.setTime(new Timestamp(System.currentTimeMillis()));
            return ResponseEntity.ok(response);
        }

        AnnouncementResponse announcementResponse = modelMapper.map(announcementDto, AnnouncementResponse.class);

        if (announcementResponse == null) {

            response.setMessage(messageProperties.hasNoRecord("announcement"));
            response.setStatus(HttpStatus.NO_CONTENT);

        } else {
            response.setMessage(messageProperties.banned("announcement"));
            response.setData(announcementResponse);
            response.setStatus(HttpStatus.OK);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    //TODO: Unban announcement =========================================================
    @PostMapping("/announcements/unban/{id}")
    public ResponseEntity<BaseApiResponse<AnnouncementResponse>> unbanAnnouncement(
            @PathVariable int id) {

        BaseApiResponse<AnnouncementResponse> response = new BaseApiResponse<>();

        AnnouncementDto announcementDto = announcementService.unban(id);
        if (announcementDto == null) {
            response.setMessage(messageProperties.hasNoRecord("announcement"));
            response.setStatus(HttpStatus.NO_CONTENT);
            response.setTime(new Timestamp(System.currentTimeMillis()));
            return ResponseEntity.ok(response);
        }

        AnnouncementResponse announcementResponse = modelMapper.map(announcementDto, AnnouncementResponse.class);

        if (announcementResponse == null) {

            response.setMessage(messageProperties.hasNoRecord("announcement"));
            response.setStatus(HttpStatus.NO_CONTENT);

        } else {
            response.setMessage(messageProperties.unbanned("announcement"));
            response.setData(announcementResponse);
            response.setStatus(HttpStatus.OK);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    //For Job seeker

    //TODO: Select all announcements by position and dates =========================================================
    @GetMapping("/announcements-employees")
    public ResponseEntity<Object> selectAllByPositionAndDates(
            @RequestParam(defaultValue = "", required = false) String position,
            @RequestParam(defaultValue = "2000-01-01", required = false) String startDate,
            @RequestParam(defaultValue = "2022-01-01", required = false) String endDate,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int pageSize) {

        BaseApiResponseWithPagination<List<AnnouncementResponseWithCompany>> response = new BaseApiResponseWithPagination<>();
        BaseApiResponse baseApiResponse = new BaseApiResponse();
        Pageable pageable = PageRequest.of(page, pageSize);
        DateValidator dateValidator = new DateValidatorUsingDateFormat("yyyy-MM-dd");
        try {
            //TODO validate date format
            if (dateValidator.isValid(startDate) && dateValidator.isValid(endDate)) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                String stDate = startDate;
                String spDate = endDate;
                Date date1 = formatter.parse(stDate);
                Date date2 = formatter.parse(spDate);

                Page<AnnouncementDto> announcementWithPage = announcementService.selectAllByPositionAndDates(position, date1, date2, pageable);

                List<AnnouncementDto> announcementDtoList = announcementWithPage.getContent();

                List<AnnouncementResponseWithCompany> announcementResponseList = new ArrayList<>();

                Pagination pagination = new Pagination();
                pagination.setPageSize(announcementWithPage.getSize());
                pagination.setCurrentPage(announcementWithPage.getNumber());
                pagination.setTotalItems(announcementWithPage.getTotalElements());
                pagination.setTotalPages(announcementWithPage.getTotalPages());

                for (int i=0;i< announcementDtoList.size();i++) {
                    //TODO consume company
                    Company company=announcementService.companyById(announcementDtoList.get(i).getCompanyId());
                    announcementResponseList.add(modelMapper.map(announcementDtoList.get(i), AnnouncementResponseWithCompany.class));
                    if(company!=null){
                        //TODO add company to response when not null
                        announcementResponseList.get(i).setCompany(company);
                    }else{
                        announcementResponseList.get(i).setCompany(null);
                    }


                }

                if (announcementResponseList.isEmpty()) {

                    response.setMessage(messageProperties.hasNoRecords("announcements"));
                    response.setData(new ArrayList<>());
                    response.setPagination(pagination);
                    response.setStatus(HttpStatus.NO_CONTENT);

                } else {

                    response.setMessage(messageProperties.selected("announcements"));
                    response.setData(announcementResponseList);
                    response.setPagination(pagination);
                    response.setStatus(HttpStatus.OK);
                }

                response.setTime(new Timestamp(System.currentTimeMillis()));
                return ResponseEntity.ok(response);
            } else {
                baseApiResponse.setMessage("Please input with date format (yyyy-MM-dd)");
                baseApiResponse.setData(null);
                baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
                baseApiResponse.setStatus(HttpStatus.BAD_REQUEST);
                return ResponseEntity.ok(baseApiResponse);
            }
        } catch (ParseException e) {
            baseApiResponse.setMessage(e.getMessage());
            baseApiResponse.setData(null);
            baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
            baseApiResponse.setStatus(HttpStatus.BAD_REQUEST);
            return ResponseEntity.ok(baseApiResponse);
        }

    }

    //For HR

    //TODO: Select all announcements =========================================================
    @GetMapping("/announcements-hr")
    public ResponseEntity<BaseApiResponseWithPagination<List<AnnouncementResponse>>> findAllNotBanned(
            @RequestParam(defaultValue = "", required = false) String position,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int pageSize) {

        BaseApiResponseWithPagination<List<AnnouncementResponse>> response = new BaseApiResponseWithPagination<>();
        Pageable pageable = PageRequest.of(page, pageSize);

        Page<AnnouncementDto> announcementWithPage = announcementService.findAllByPosition(position, pageable);

        List<AnnouncementDto> announcementDtoList = announcementWithPage.getContent();

        List<AnnouncementResponse> announcementResponseList = new ArrayList<>();

        Pagination pagination = new Pagination();
        pagination.setPageSize(announcementWithPage.getSize());
        pagination.setCurrentPage(announcementWithPage.getNumber());
        pagination.setTotalItems(announcementWithPage.getTotalElements());
        pagination.setTotalPages(announcementWithPage.getTotalPages());

        for (AnnouncementDto announcementDto : announcementDtoList) {
            AnnouncementResponse announcementResponse = modelMapper.map(announcementDto, AnnouncementResponse.class);
            int candidateCount = candidateService.countCandidatesByAnnouncement(announcementDto.getId());
            announcementResponse.setCandidateCount(candidateCount);
            announcementResponseList.add(announcementResponse);
        }

        if (announcementResponseList.isEmpty()) {

            response.setMessage(messageProperties.hasNoRecords("announcements"));
            response.setData(new ArrayList<>());
            response.setPagination(pagination);
            response.setStatus(HttpStatus.NO_CONTENT);

        } else {

            response.setMessage(messageProperties.selected("announcements"));
            response.setData(announcementResponseList);
            response.setPagination(pagination);
            response.setStatus(HttpStatus.OK);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }


    //TODO: Select announcement by id =========================================================
    @GetMapping("/announcements/{id}")
    public ResponseEntity<BaseApiResponse<AnnouncementResponse>> findAnnouncementById(@PathVariable int id) {

        BaseApiResponse<AnnouncementResponse> baseApiResponse = new BaseApiResponse<>();

        AnnouncementDto announcementDto = announcementService.selectById(id);

        if (announcementDto == null) {

            baseApiResponse.setMessage(messageProperties.hasNoRecord("announcement"));
            baseApiResponse.setStatus(HttpStatus.NO_CONTENT);
        } else {

            AnnouncementResponse response = modelMapper.map(announcementDto, AnnouncementResponse.class);
            baseApiResponse.setMessage(messageProperties.selectedOne("announcement"));
            baseApiResponse.setData(response);
            baseApiResponse.setStatus(HttpStatus.OK);
        }

        baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(baseApiResponse);
    }


    //TODO: Insert announcement =========================================================
    @PostMapping("/announcements")
    public ResponseEntity<BaseApiResponse<AnnouncementResponse>> insertAnnouncement(
            @Valid @RequestBody AnnouncementRequest announcementRequest) {
        try {
            // TODO Valid date format
            DateValidator dateValidator = new DateValidatorUsingDateFormat("yyyy-MM-dd");
            if (dateValidator.isValid(announcementRequest.getClosedDate()) && dateValidator.isValid(announcementRequest.getPublishedDate())) {
                BaseApiResponse<AnnouncementResponse> response = new BaseApiResponse<>();

                AnnouncementDto announcementDto = modelMapper.map(announcementRequest, AnnouncementDto.class);

                AnnouncementDto result = announcementService.insert(announcementDto);
                AnnouncementResponse announcementResponse = modelMapper.map(result, AnnouncementResponse.class);

                response.setMessage(messageProperties.inserted("Announcement"));
                announcementResponse.setId(result.getId());

                response.setData(announcementResponse);
                response.setStatus(HttpStatus.CREATED);

                response.setTime(new Timestamp(System.currentTimeMillis()));
                return ResponseEntity.ok(response);
            } else {
                BaseApiResponse baseApiResponse = new BaseApiResponse();
                baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
                baseApiResponse.setStatus(HttpStatus.BAD_REQUEST);
                baseApiResponse.setMessage("Please input with date format (yyyy-MM-dd)");
                baseApiResponse.setData(null);
                return ResponseEntity.ok(baseApiResponse);
            }

        } catch (ParseException e) {
            BaseApiResponse baseApiResponse = new BaseApiResponse();
            baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
            baseApiResponse.setStatus(HttpStatus.BAD_REQUEST);
            baseApiResponse.setMessage(e.getLocalizedMessage());
            baseApiResponse.setData(null);
            return ResponseEntity.ok(baseApiResponse);
        }

    }

    //TODO: Delete announcement =========================================================
    @DeleteMapping("/announcements/{id}")
    private ResponseEntity<BaseApiResponse<AnnouncementResponse>> deleteAnnouncement(@Valid @PathVariable("id") int id) {

        BaseApiResponse<AnnouncementResponse> response = new BaseApiResponse<>();

        AnnouncementDto announcementDto = announcementService.delete(id);


        if (announcementDto == null) {

            response.setMessage(messageProperties.deletedError("announcement", "announcement"));
            response.setStatus(HttpStatus.NO_CONTENT);

        } else {
            AnnouncementResponse announcementResponse = modelMapper.map(announcementDto, AnnouncementResponse.class);
            response.setMessage(messageProperties.deleted("announcement"));
            response.setData(announcementResponse);
            response.setStatus(HttpStatus.OK);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    //TODO: Update announcement =========================================================
    @PutMapping("/announcements/{id}")
    private ResponseEntity<BaseApiResponse<AnnouncementResponse>> updateAnnouncement(
            @PathVariable int id,
            @Valid @RequestBody AnnouncementRequest announcementRequest) {
        DateValidator dateValidator = new DateValidatorUsingDateFormat("yyyy-MM-dd");
        try {
            if (dateValidator.isValid(announcementRequest.getClosedDate()) && dateValidator.isValid(announcementRequest.getPublishedDate())) {
                BaseApiResponse<AnnouncementResponse> response = new BaseApiResponse<>();

                AnnouncementDto announcementDto = modelMapper.map(announcementRequest, AnnouncementDto.class);
                announcementDto.setId(id);
                AnnouncementDto announcementResponseDto = announcementService.update(announcementDto);
                if (announcementResponseDto == null) {

                    response.setMessage(messageProperties.updatedError("announcement"));
                    response.setStatus(HttpStatus.NO_CONTENT);

                } else {

                    AnnouncementResponse announcementResponse = modelMapper.map(announcementResponseDto, AnnouncementResponse.class);
                    response.setMessage(messageProperties.updated("announcement"));
                    response.setData(announcementResponse);
                    response.setStatus(HttpStatus.OK);
                }

                response.setTime(new Timestamp(System.currentTimeMillis()));
                return ResponseEntity.ok(response);

            } else {
                BaseApiResponse baseApiResponse = new BaseApiResponse();
                baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
                baseApiResponse.setStatus(HttpStatus.BAD_REQUEST);
                baseApiResponse.setMessage("Please input with date format (yyyy-MM-dd)");
                baseApiResponse.setData(null);
                return ResponseEntity.ok(baseApiResponse);
            }

        } catch (ParseException e) {
            BaseApiResponse baseApiResponse = new BaseApiResponse();
            baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
            baseApiResponse.setStatus(HttpStatus.BAD_REQUEST);
            baseApiResponse.setMessage(e.getLocalizedMessage());
            baseApiResponse.setData(null);
            return ResponseEntity.ok(baseApiResponse);
        }

    }


    //TODO: Share announcement =========================================================
    @PostMapping("/announcements/share/{id}")
    public ResponseEntity<BaseApiResponse<AnnouncementResponse>> shareAnnouncement(
            @PathVariable int id) {

        BaseApiResponse<AnnouncementResponse> response = new BaseApiResponse<>();

        AnnouncementDto announcementDto = announcementService.share(id);

        if (announcementDto == null) {
            response.setMessage(messageProperties.hasNoRecord("announcement"));
            response.setStatus(HttpStatus.NO_CONTENT);
            response.setTime(new Timestamp(System.currentTimeMillis()));
            return ResponseEntity.ok(response);
        }

        AnnouncementResponse announcementResponse = modelMapper.map(announcementDto, AnnouncementResponse.class);

        if (announcementResponse == null) {

            response.setMessage(messageProperties.hasNoRecord("announcement"));
            response.setStatus(HttpStatus.NO_CONTENT);

        } else {
            response.setMessage(messageProperties.shared("announcement"));
            response.setData(announcementResponse);
            response.setStatus(HttpStatus.OK);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    //TODO: Unshare announcement =========================================================
    @PostMapping("/announcements/unshare/{id}")
    public ResponseEntity<BaseApiResponse<AnnouncementResponse>> unshareAnnouncement(
            @PathVariable int id) {

        BaseApiResponse<AnnouncementResponse> response = new BaseApiResponse<>();

        AnnouncementDto announcementDto = announcementService.unshare(id);

        if (announcementDto == null) {
            response.setMessage(messageProperties.hasNoRecord("announcement"));
            response.setStatus(HttpStatus.NO_CONTENT);
            response.setTime(new Timestamp(System.currentTimeMillis()));
            return ResponseEntity.ok(response);
        }

        AnnouncementResponse announcementResponse = modelMapper.map(announcementDto, AnnouncementResponse.class);

        if (announcementResponse == null) {

            response.setMessage(messageProperties.hasNoRecord("announcement"));
            response.setStatus(HttpStatus.NO_CONTENT);

        } else {
            response.setMessage(messageProperties.unshared("announcement"));
            response.setData(announcementResponse);
            response.setStatus(HttpStatus.OK);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    //TODO: Draft announcement =========================================================
    @PostMapping("/announcements/draft/{id}")
    public ResponseEntity<BaseApiResponse<AnnouncementResponse>> draftAnnouncement(
            @PathVariable int id) {

        BaseApiResponse<AnnouncementResponse> response = new BaseApiResponse<>();

        AnnouncementDto announcementDto = announcementService.draft(id);

        if (announcementDto == null) {
            response.setMessage(messageProperties.hasNoRecord("announcement"));
            response.setStatus(HttpStatus.NO_CONTENT);
            response.setTime(new Timestamp(System.currentTimeMillis()));
            return ResponseEntity.ok(response);
        }

        AnnouncementResponse announcementResponse = modelMapper.map(announcementDto, AnnouncementResponse.class);

        if (announcementResponse == null) {

            response.setMessage(messageProperties.hasNoRecord("announcement"));
            response.setStatus(HttpStatus.NO_CONTENT);

        } else {
            response.setMessage(messageProperties.draft("announcement"));
            response.setData(announcementResponse);
            response.setStatus(HttpStatus.OK);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    //TODO: Undraft announcement =========================================================
    @PostMapping("/announcements/undraft/{id}")
    public ResponseEntity<BaseApiResponse<AnnouncementResponse>> unDraftAnnouncement(
            @PathVariable int id) {

        BaseApiResponse<AnnouncementResponse> response = new BaseApiResponse<>();

        AnnouncementDto announcementDto = announcementService.undraft(id);
        if (announcementDto == null) {
            response.setMessage(messageProperties.hasNoRecord("announcement"));
            response.setStatus(HttpStatus.NO_CONTENT);
            response.setTime(new Timestamp(System.currentTimeMillis()));
            return ResponseEntity.ok(response);
        }

        AnnouncementResponse announcementResponse = modelMapper.map(announcementDto, AnnouncementResponse.class);

        if (announcementResponse == null) {

            response.setMessage(messageProperties.hasNoRecord("announcement"));
            response.setStatus(HttpStatus.NO_CONTENT);

        } else {
            response.setMessage(messageProperties.undraft("announcement"));
            response.setData(announcementResponse);
            response.setStatus(HttpStatus.OK);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    //TODO: Select draft =========================================================
    @GetMapping("/announcements/company/draft/{companyId}")
    public ResponseEntity<Object> findDraft(
            @PathVariable int companyId,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int pageSize,
            @RequestParam(defaultValue = "" ,required = false) String caption,
            @RequestParam(defaultValue = "",required = false) String position

            )
    {

        BaseApiResponseWithPagination<List<AnnouncementResponse>> response = new BaseApiResponseWithPagination<>();
        Pageable pageable = PageRequest.of(page, pageSize);
        if(position.isBlank()||position.isEmpty() ||position==null){
            Page<AnnouncementDto> announcementWithPage = announcementService.selectDraft(companyId,caption,pageable);
            return listAnnouncement(announcementWithPage,response);
        }else{
            Page<AnnouncementDto> announcementWithPage = announcementService.selectDraftByCompanyAndPosition(companyId,position,pageable);
            return listAnnouncement(announcementWithPage,response);
        }


    }

    @GetMapping("/announcements/company/closed-announcement/{companyId}")
    public ResponseEntity<Object> selectByClosedDate(
            @PathVariable int companyId,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int pageSize,
            @RequestParam(defaultValue = "", required = false) String caption,
            @RequestParam(defaultValue = "", required = false) String position
    ) {

        BaseApiResponseWithPagination<List<AnnouncementResponse>> response = new BaseApiResponseWithPagination<>();
        Pageable pageable = PageRequest.of(page, pageSize);
        System.out.println(position);
        if (position.isBlank()|| position.isEmpty() || position==null) {
            Page<AnnouncementDto> announcementWithPage = announcementService.findAllByCompanyIdAndClosedDate(companyId, caption, util.getCurrentDate(), pageable);
            return listAnnouncement(announcementWithPage, response);
        } else {
            Page<AnnouncementDto> announcementWithPage = announcementService.filterCloseAnnouncementByCompanyIdAndPosition(companyId, position, util.getCurrentDate(), pageable);
            return listAnnouncement(announcementWithPage, response);
        }

    }


    //TODO select all position
    @GetMapping("/announcements/company/list-position/{companyId}")
    public ResponseEntity<Object> selectAllPositionByCompany(@PathVariable int companyId) {
        BaseApiResponse<List<String>> apiResponse = new BaseApiResponse<>();
        List<String> listPosition = announcementService.selectAllPosition(companyId);
        if (listPosition.size() <= 0) {
            apiResponse.setTime(new Timestamp(System.currentTimeMillis()));
            apiResponse.setStatus(HttpStatus.FOUND);
            apiResponse.setMessage(messageProperties.hasNoRecords("position"));
            apiResponse.setData(null);
            return ResponseEntity.ok(apiResponse);
        } else {
            apiResponse.setTime(new Timestamp(System.currentTimeMillis()));
            apiResponse.setStatus(HttpStatus.FOUND);
            apiResponse.setMessage(messageProperties.selected("position"));
            apiResponse.setData(listPosition);
            return ResponseEntity.ok(apiResponse);
        }
    }


    //TODO Active Announcement
    @GetMapping("/announcements/company/active-announcement/{companyId}")
    public ResponseEntity<Object> selectActiveAnnouncementByCompany(
            @PathVariable int companyId,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int pageSize,
            @RequestParam(defaultValue = "") String caption,
            @RequestParam(defaultValue = "") String position
    ) {

        BaseApiResponseWithPagination<List<AnnouncementResponse>> response = new BaseApiResponseWithPagination<>();
        Pageable pageable = PageRequest.of(page, pageSize);
        if(position.isBlank()|| position.isEmpty() || position==null){
            Page<AnnouncementDto> announcementWithPage = announcementService.selectActiveAnnouncementByCompanyId(companyId, caption, util.getCurrentDate(), pageable);
            return listAnnouncement(announcementWithPage, response);
        }else{
            Page<AnnouncementDto> announcementWithPage = announcementService.filterActiveAnnouncementByCompanyIdAndPosition(companyId, position, util.getCurrentDate(), pageable);
            return listAnnouncement(announcementWithPage, response);
        }

    }

    //TODO function list Announcement
    public ResponseEntity<Object> listAnnouncement(Page<AnnouncementDto> announcementWithPage, BaseApiResponseWithPagination<List<AnnouncementResponse>> response) {

        List<AnnouncementDto> announcementDtoList = announcementWithPage.getContent();

        List<AnnouncementResponse> announcementResponseList = new ArrayList<>();

        Pagination pagination = new Pagination();
        pagination.setPageSize(announcementWithPage.getSize());
        pagination.setCurrentPage(announcementWithPage.getNumber());
        pagination.setTotalItems(announcementWithPage.getTotalElements());
        pagination.setTotalPages(announcementWithPage.getTotalPages());

        for (AnnouncementDto announcementDto : announcementDtoList) {
            AnnouncementResponse announcementResponse = modelMapper.map(announcementDto, AnnouncementResponse.class);
            int candidateCount = candidateService.countCandidatesByAnnouncement(announcementDto.getId());
            announcementResponse.setCandidateCount(candidateCount);
            announcementResponseList.add(announcementResponse);
        }

        if (announcementResponseList.isEmpty()) {

            response.setMessage(messageProperties.hasNoRecords("announcements"));
            response.setData(new ArrayList<>());
            response.setPagination(pagination);
            response.setStatus(HttpStatus.NO_CONTENT);

        } else {

            response.setMessage(messageProperties.selected("announcements"));
            response.setData(announcementResponseList);
            response.setPagination(pagination);
            response.setStatus(HttpStatus.OK);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }
}
