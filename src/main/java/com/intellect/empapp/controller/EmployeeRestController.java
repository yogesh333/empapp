package com.intellect.empapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intellect.empapp.model.Employee;
import com.intellect.empapp.response.EmployeeResponse;
import com.intellect.empapp.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeRestController {

	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ResponseEntity<EmployeeResponse> create(@RequestBody Employee createEmployeeRequest){
		logger.debug("Entering inside create(@RequestBody Employee createEmployeeRequest) method");
		return employeeService.createEmployee(createEmployeeRequest);
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ResponseEntity<EmployeeResponse> delete(@RequestBody Employee createEmployeeRequest){
		logger.debug("Entering inside delete(@RequestBody Employee createEmployeeRequest) method");
		return null;
	}
	
}
