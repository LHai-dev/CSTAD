package com.job_room.employee_service.rest.controller;

import com.job_room.employee_service.model.Employee;
import com.job_room.employee_service.model.request.EmployeeRequest;
import com.job_room.employee_service.model.response.EmployeeResponse;
import com.job_room.employee_service.rest.message.*;
import com.job_room.employee_service.service.EmployeeService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    private EmployeeService employeeService;
    private MessageProperties messageProperties;
    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
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

        response.setMessage(messageProperties.insertError("Employee"));
        response.setError(errors);
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setTime(new Timestamp(System.currentTimeMillis()));

        return ResponseEntity.ok(response);
    }

    //TODO Add Employee =========================================================
    @PostMapping("/employees")
    public ResponseEntity<BaseApiResponse<EmployeeResponse>> addEmployee(@Valid @RequestBody EmployeeRequest employee){
        ModelMapper modelMapper=new ModelMapper();

        BaseApiResponse<EmployeeResponse> baseApiResponse=new BaseApiResponse<>();
        Employee employeeDto=modelMapper.map(employee,Employee.class);
        EmployeeResponse employeeResponse=modelMapper.map(employeeDto,EmployeeResponse.class);

        employeeService.addEmployee(employeeDto);

        employeeResponse.setId(employeeDto.getId());
        baseApiResponse.setData(employeeResponse);
        baseApiResponse.setMessage(messageProperties.inserted("Employee"));
        baseApiResponse.setStatus(HttpStatus.CREATED);
        baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(baseApiResponse);
    }
    //TODO FindAll Employee =========================================================
    @GetMapping("/employees")
    public ResponseEntity<BaseApiResponseWithPagination<List<Employee>>> findAll(
            @RequestParam(defaultValue = "") String fullName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10")int pageSize){

        Pageable pageable = PageRequest.of(page,pageSize);
        BaseApiResponseWithPagination<List<Employee>> baseApiResponseWithPagination = new BaseApiResponseWithPagination<>();
        Page<Employee> employeePage=employeeService.findAllByFullName(fullName,pageable);
        Pagination pagination = new Pagination();

        if(employeePage.getContent().isEmpty()){

            baseApiResponseWithPagination.setTime(new Timestamp(System.currentTimeMillis()));
            baseApiResponseWithPagination.setStatus(HttpStatus.NO_CONTENT);
            baseApiResponseWithPagination.setMessage(messageProperties.hasNoRecords("Employee"));
            baseApiResponseWithPagination.setData(new ArrayList<>());
            baseApiResponseWithPagination.setPagination(pagination);
            return ResponseEntity.ok(baseApiResponseWithPagination);
        }else{

            pagination.setCurrentPage(employeePage.getNumber());
            pagination.setTotalItems(employeePage.getTotalElements());
            pagination.setTotalPages(employeePage.getTotalPages());
            pagination.setPageSize(employeePage.getSize());

            baseApiResponseWithPagination.setData(employeePage.getContent());
            baseApiResponseWithPagination.setMessage(messageProperties.selected("Employees"));
            baseApiResponseWithPagination.setPagination(pagination);
            baseApiResponseWithPagination.setStatus(HttpStatus.FOUND);
            baseApiResponseWithPagination.setTime(new Timestamp(System.currentTimeMillis()));
            return ResponseEntity.ok(baseApiResponseWithPagination);
        }
    }




    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable int id){
        Employee employee=employeeService.deleteEmployee(id);
        ModelMapper modelMapper=new ModelMapper();
        BaseApiResponse<EmployeeResponse> baseApiResponse=new BaseApiResponse<>();
        ErrorMessage errorMessage=new ErrorMessage();
        EmployeeResponse employeeResponse=new EmployeeResponse();
        if(employee!=null){
            employeeResponse=modelMapper.map(employee,EmployeeResponse.class);
            baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
            baseApiResponse.setStatus(HttpStatus.OK);
            baseApiResponse.setData(employeeResponse);
            baseApiResponse.setMessage(messageProperties.deleted("Employee"));
            return ResponseEntity.ok(baseApiResponse);
        }else{
            errorMessage.setMessage(messageProperties.deletedError("Employee",String.valueOf(id)));
            errorMessage.setStatus(HttpStatus.BAD_REQUEST);
            errorMessage.setTime(new Timestamp(System.currentTimeMillis()));
            return ResponseEntity.ok(errorMessage);
        }
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id){
        Employee employee=employeeService.findById(id);
        ModelMapper modelMapper=new ModelMapper();
        EmployeeResponse employeeResponse;
        BaseApiResponse<EmployeeResponse> baseApiResponse=new BaseApiResponse<>();
        ErrorMessage errorMessage=new ErrorMessage();
        if(employee!=null){
            employeeResponse=modelMapper.map(employee,EmployeeResponse.class);
            baseApiResponse.setMessage(messageProperties.selectedOne("Employee"));
            baseApiResponse.setData(employeeResponse);
            baseApiResponse.setStatus(HttpStatus.FOUND);
            baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
            return ResponseEntity.ok(baseApiResponse);
        }else{
            errorMessage.setTime(new Timestamp(System.currentTimeMillis()));
            errorMessage.setStatus(HttpStatus.NO_CONTENT);
            errorMessage.setMessage(messageProperties.hasNoRecord("Employee"));
            return ResponseEntity.ok(errorMessage);
        }
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable int id,@RequestBody EmployeeRequest employeeRequest){
        Employee employee=employeeService.findById(id);
        ModelMapper modelMapper=new ModelMapper();
        EmployeeResponse employeeResponse;
        BaseApiResponse<EmployeeResponse> baseApiResponse=new BaseApiResponse<>();
        ErrorMessage errorMessage=new ErrorMessage();
        if(employee!=null){
            employee.setFullName(employeeRequest.getFull_name());
            employee.setDateOfBirth(employeeRequest.getDate_of_birth());
            employee.setAddress(employeeRequest.getAddress());
            employee.setEmail(employeeRequest.getEmail());
            employee.setGender(employeeRequest.getGender());
            employee.setPassword(employeeRequest.getPassword());
            employee.setProfilePicture(employeeRequest.getProfile_picture());
            employee.setTelephone(employeeRequest.getTelephone());
            employeeResponse=modelMapper.map(employeeService.updateEmployee(employee),EmployeeResponse.class);
            baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
            baseApiResponse.setStatus(HttpStatus.OK);
            baseApiResponse.setData(employeeResponse);
            baseApiResponse.setMessage(messageProperties.updated("Employee"));
            return ResponseEntity.ok(baseApiResponse);
        }else {
            errorMessage.setTime(new Timestamp(System.currentTimeMillis()));
            errorMessage.setStatus(HttpStatus.NO_CONTENT);
            errorMessage.setMessage(messageProperties.hasNoRecord("Employee"));
            return ResponseEntity.ok(errorMessage);
        }
    }
}
