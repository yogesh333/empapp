package com.intellect.empapp.service;

import org.springframework.http.ResponseEntity;

import com.intellect.empapp.model.Employee;
import com.intellect.empapp.response.EmployeeResponse;

public interface EmployeeService {
     ResponseEntity<EmployeeResponse> createEmployee(Employee createEmployeeRequest);
     ResponseEntity<EmployeeResponse> updateEmployee(Employee createEmployeeRequest);
     ResponseEntity<EmployeeResponse> deleteEmployee(String employeeId);

}
