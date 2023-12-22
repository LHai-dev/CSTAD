package com.job_room.employee_service.repository;

import com.job_room.employee_service.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Page<Employee> findAllByFullNameContaining(String fullName,Pageable pageable);
}
