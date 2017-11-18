package com.intellect.empapp.dao;

import java.util.ArrayList;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.intellect.empapp.controller.EmployeeRestController;
import com.intellect.empapp.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);
	
	private java.util.List<Employee> employeeList = new ArrayList<>();
	
	@Override
	public Employee saveEmployee(Employee createEmployeeRequest) {
		String employeeId = UUID.randomUUID().toString();
		createEmployeeRequest.setId(employeeId);
		employeeList.add(createEmployeeRequest);
		showEmployeeList();
		return createEmployeeRequest;
	}

	@Override
	public Employee updateEmployee(Employee createEmployeeRequest) {
		showEmployeeList();
		return null;
	}

	@Override
	public Boolean removeEmployee(String employeeId) {
		return this.employeeList.removeIf(emp -> emp.getId().equals(employeeId));
	}
	
	
	public Boolean isEmployeeAlreadyExist(Employee employee){
		return this.employeeList.stream().anyMatch(emp -> emp.getEmail().equals(employee.getEmail()));
	}
	
	private void showEmployeeList(){
		this.employeeList.forEach(emp -> logger.debug("Employee {} " , emp));
	}

}
