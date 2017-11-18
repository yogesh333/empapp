package com.intellect.empapp.service;

import java.awt.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.intellect.empapp.dao.EmployeeDao;
import com.intellect.empapp.dao.EmployeeDaoImpl;
import com.intellect.empapp.model.Employee;
import com.intellect.empapp.response.EmployeeResponse;
import static com.intellect.empapp.validation.EmployeeValidation.isInvalidcreateEmployeeRequest;;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public ResponseEntity<EmployeeResponse> createEmployee(Employee createEmployeeRequest) {
		logger.debug("entering inside createEmployee(Employee createEmployeeRequest) method");
		logger.debug("Create Employee Request : {} ", createEmployeeRequest);
		EmployeeResponse createEmployeeResponse = isInvalidcreateEmployeeRequest(createEmployeeRequest);
		if(!createEmployeeResponse.getValErrors().isEmpty()){
			return new ResponseEntity<EmployeeResponse>(createEmployeeResponse, HttpStatus.OK);
		}
		createEmployeeResponse = new EmployeeResponse();
		if(employeeDao.isEmployeeAlreadyExist(createEmployeeRequest)){
			logger.debug("entering inside createEmployee(Employee createEmployeeRequest) method");
			createEmployeeResponse.setResMsg("employee with the given email id already exist, please try another email id");
			return new ResponseEntity<EmployeeResponse>(createEmployeeResponse, HttpStatus.OK);
		}
		Employee foundEmp = employeeDao.saveEmployee(createEmployeeRequest);
		createEmployeeResponse.setUserId(foundEmp.getId());
		createEmployeeResponse.setResMsg("Employee with given information created successfully");
		return new ResponseEntity<EmployeeResponse>(createEmployeeResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<EmployeeResponse> updateEmployee(Employee createEmployeeRequest) {
		logger.debug("entering inside updateEmployee(Employee createEmployeeRequest) method");
		logger.debug("Update Employee Request : {} ", createEmployeeRequest);
		EmployeeResponse updateEmployeeResponse = new EmployeeResponse();
		Employee foundEmployee = employeeDao.findEmployee(createEmployeeRequest.getId());
		if(null == foundEmployee){
			updateEmployeeResponse.setResMsg("employee with given details not found");
			return new ResponseEntity<EmployeeResponse>(updateEmployeeResponse, HttpStatus.OK);
		}
		foundEmployee = employeeDao.updateEmployee(createEmployeeRequest);
		updateEmployeeResponse.setResMsg("employee with given details updated successfully");
		updateEmployeeResponse.setUserId(foundEmployee.getId());
		return new ResponseEntity<EmployeeResponse>(updateEmployeeResponse, HttpStatus.OK);	
	}


	@Override
	public ResponseEntity<EmployeeResponse> deleteEmployee(String employeeId) {
		logger.debug("entering inside deleteEmployee(String employeeId) method");
		logger.debug("Delete Employee Request : {} ", employeeId);
		EmployeeResponse deleteResponse = new EmployeeResponse(); 
		if(employeeDao.isEmployeeAlreadyExist(new Employee(employeeId))){
			deleteResponse.setUserId(employeeId);
			deleteResponse.setResMsg("employee to be deleted with given if not found");
		}
		if(employeeDao.removeEmployee(employeeId)){
			deleteResponse.setUserId(employeeId);
			deleteResponse.setResMsg("employee successfully deleted with given id");
		}else{
			deleteResponse.setUserId(employeeId);
			deleteResponse.setResMsg("employee deletion with given id failed");
		}
		return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
	}
}
