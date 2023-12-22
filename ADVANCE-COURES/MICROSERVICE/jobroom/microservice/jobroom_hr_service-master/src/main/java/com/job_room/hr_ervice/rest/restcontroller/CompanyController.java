package com.job_room.hr_ervice.rest.restcontroller;

import com.job_room.hr_ervice.model.company.CompanyDto;
import com.job_room.hr_ervice.model.company.CompanyRequest;
import com.job_room.hr_ervice.model.company.CompanyResponse;
import com.job_room.hr_ervice.rest.message.*;
import com.job_room.hr_ervice.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CompanyController {

    private CompanyService companyService;

    private MessageProperties messageProperties;

    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    public void setMessageProperties(MessageProperties messageProperties) {
        this.messageProperties = messageProperties;
    }
    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
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

        response.setMessage(messageProperties.insertError("Alumni"));
        response.setError(errors);
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setTime(new Timestamp(System.currentTimeMillis()));

        return ResponseEntity.ok(response);
    }

    //For admin

    //TODO: Select all companies =========================================================
    @GetMapping("/companies")
    public ResponseEntity<BaseApiResponseWithPagination<List<CompanyResponse>>> findAll(
            @RequestParam(defaultValue = "",required = false) String name,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int pageSize) {

        BaseApiResponseWithPagination<List<CompanyResponse>> response = new BaseApiResponseWithPagination<>();
        Pageable pageable = PageRequest.of(page,pageSize, Sort.by(Sort.Direction.DESC,"id"));

        Page<CompanyDto> companyWithPage =  companyService.findAll(name,pageable);

        List<CompanyDto> companyList = companyWithPage.getContent();

        List<CompanyResponse> companyResponseList = new ArrayList<>();

        for (CompanyDto companyDto : companyList) {
            companyResponseList.add(modelMapper.map(companyDto, CompanyResponse.class));
        }

        Pagination pagination = new Pagination();
        pagination.setPageSize(companyWithPage.getSize());
        pagination.setCurrentPage(companyWithPage.getNumber());
        pagination.setTotalItems(companyWithPage.getTotalElements());
        pagination.setTotalPages(companyWithPage.getTotalPages());

        if (companyResponseList.isEmpty()) {

            response.setMessage(messageProperties.hasNoRecords("Companies"));
            response.setData(new ArrayList<>());
            response.setPagination(pagination);
            response.setStatus(HttpStatus.NO_CONTENT);

        } else {

            response.setMessage(messageProperties.selected("Companies"));
            response.setData(companyResponseList);
            response.setPagination(pagination);
            response.setStatus(HttpStatus.OK);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    //TODO: Count all companies =========================================================
    @GetMapping("/companies/count")
    public ResponseEntity<BaseApiResponse<Integer>> countAll() {

        BaseApiResponse<Integer> response = new BaseApiResponse<>();

        int companyCount = companyService.countAllCompany();

        response.setMessage(messageProperties.selected("Companies"));
        response.setData(companyCount);
        response.setStatus(HttpStatus.OK);
        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    //TODO: Ban company =========================================================
    @PostMapping("/companies/ban/{id}")
    public ResponseEntity<BaseApiResponse<CompanyResponse>> banCompany(
            @PathVariable int id) {

        BaseApiResponse<CompanyResponse> response = new BaseApiResponse<>();

        CompanyDto companyDto = companyService.ban(id);
        if(companyDto ==null){

            response.setMessage(messageProperties.hasNoRecord("company"));
            response.setStatus(HttpStatus.NO_CONTENT);
            response.setTime(new Timestamp(System.currentTimeMillis()));
            return ResponseEntity.ok(response);
        }

        CompanyResponse companyResponse = modelMapper.map(companyDto, CompanyResponse.class);

        if (companyResponse == null) {

            response.setMessage(messageProperties.hasNoRecord("announcement"));
            response.setStatus(HttpStatus.NO_CONTENT);

        } else {
            response.setMessage(messageProperties.banned("announcement"));
            response.setData(companyResponse);
            response.setStatus(HttpStatus.OK);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    //TODO: Unban company =========================================================
    @PostMapping("/companies/unban/{id}")
    public ResponseEntity<BaseApiResponse<CompanyResponse>> unbanCompany(
            @PathVariable int id) {

        BaseApiResponse<CompanyResponse> response = new BaseApiResponse<>();

        CompanyDto companyDto = companyService.unban(id);
        if(companyDto ==null){

            response.setMessage(messageProperties.hasNoRecord("company"));
            response.setStatus(HttpStatus.NO_CONTENT);
            response.setTime(new Timestamp(System.currentTimeMillis()));
            return ResponseEntity.ok(response);
        }

        CompanyResponse companyResponse = modelMapper.map(companyDto, CompanyResponse.class);

        if (companyResponse == null) {

            response.setMessage(messageProperties.hasNoRecord("announcement"));
            response.setStatus(HttpStatus.NO_CONTENT);

        } else {
            response.setMessage(messageProperties.banned("announcement"));
            response.setData(companyResponse);
            response.setStatus(HttpStatus.OK);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    //TODO: Select company by id =========================================================
    @GetMapping("/companies/{id}")
    public ResponseEntity<BaseApiResponse<CompanyResponse>> selectCompanyById(@PathVariable int id) {

        BaseApiResponse<CompanyResponse> baseApiResponse = new BaseApiResponse<>();
        CompanyDto companyDto = companyService.selectById(id);

        if(companyDto==null){

            baseApiResponse.setMessage(messageProperties.hasNoRecord("company"));
            baseApiResponse.setStatus(HttpStatus.NO_CONTENT);
        }
        else {

            CompanyResponse response =  modelMapper.map(companyDto,CompanyResponse.class);
            baseApiResponse.setMessage(messageProperties.selectedOne("company"));
            baseApiResponse.setData(response);
            baseApiResponse.setStatus(HttpStatus.OK);
        }

        baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(baseApiResponse);
    }

    //TODO: Select company with announcements =========================================================
    @GetMapping("/companies-announcements/{id}")
    public ResponseEntity<BaseApiResponse<CompanyAnnouncement>> selectCompanyWithAnnouncements(@PathVariable int id) {

        BaseApiResponse<CompanyAnnouncement> baseApiResponse = new BaseApiResponse<>();

        CompanyAnnouncement companyAnnouncement = companyService.selectCompanyWithAnnouncements(id);

        if(companyAnnouncement==null){

            baseApiResponse.setMessage(messageProperties.hasNoRecord("company"));
            baseApiResponse.setStatus(HttpStatus.NO_CONTENT);
        }
        else {

            baseApiResponse.setMessage(messageProperties.selectedOne("company"));
            baseApiResponse.setData(companyAnnouncement);
            baseApiResponse.setStatus(HttpStatus.OK);
        }

        baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(baseApiResponse);
    }


    //TODO: Insert company =========================================================
    @PostMapping("/companies")
    public ResponseEntity<BaseApiResponse<CompanyResponse>> insertCompany(
            @Valid @RequestBody CompanyRequest companyRequest) {


        BaseApiResponse<CompanyResponse> response = new BaseApiResponse<>();
        ModelMapper mapper = new ModelMapper();

        CompanyDto companyDto = mapper.map(companyRequest, CompanyDto.class);

        CompanyDto result = companyService.insert(companyDto);
        CompanyResponse companyResponse = mapper.map(result, CompanyResponse.class);
        response.setMessage(messageProperties.inserted("Company"));
        companyResponse.setId(result.getId());
        response.setData(companyResponse);
        response.setStatus(HttpStatus.CREATED);

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    //TODO: Delete company =========================================================
    @DeleteMapping("/companies/{id}")
        private ResponseEntity<BaseApiResponse<CompanyResponse>> deleteCompany( @Valid @PathVariable("id") int id) {

        BaseApiResponse<CompanyResponse> response = new BaseApiResponse<>();

        CompanyDto companyDto = companyService.delete(id);

        if(companyDto==null){

            response.setMessage(messageProperties.deletedError("company","company"));
            response.setStatus(HttpStatus.NO_CONTENT);

        }
        else{

            CompanyResponse companyResponse =  modelMapper.map(companyDto,CompanyResponse.class);
            response.setMessage(messageProperties.deleted("company"));
            response.setData(companyResponse);
            response.setStatus(HttpStatus.OK);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    //TODO: Update company =========================================================
    @PutMapping("/companies/{id}")
    private ResponseEntity<BaseApiResponse<CompanyResponse>> updateCompany(
            @PathVariable int id,
            @Valid @RequestBody  CompanyRequest companyRequest) {

        BaseApiResponse<CompanyResponse> response = new BaseApiResponse<>();
        ModelMapper modelMapper = new ModelMapper();

        CompanyDto companyDto = modelMapper.map(companyRequest,CompanyDto.class);
        companyDto.setId(id);
        CompanyDto companyResponseDto = companyService.update(companyDto);

        if(companyResponseDto==null){

            response.setMessage(messageProperties.updatedError("company"));
            response.setStatus(HttpStatus.NO_CONTENT);

        }
        else{

            CompanyResponse companyResponse =  modelMapper.map(companyResponseDto,CompanyResponse.class);
            response.setMessage(messageProperties.updated("company"));
            response.setData(companyResponse);
            response.setStatus(HttpStatus.OK);
        }

        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }
}
