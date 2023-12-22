package com.testSSE.SSE.api.employee;

import com.testSSE.SSE.api.employee.web.EmployeeDto;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    public static EmployeeDto entityToDto(Employee employee){
        EmployeeDto dto = new EmployeeDto();
        BeanUtils.copyProperties(employee,dto);
        return dto;
    }

    public static Employee dtoToEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        return employee;
    }
}
