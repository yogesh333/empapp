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
		createEmployeeRequest.setIsActive(Boolean.TRUE);
		employeeList.add(createEmployeeRequest);
		logger.debug("After adding employee");
		showEmployeeList();
		return createEmployeeRequest;
	}

	@Override
	public Employee updateEmployee(Employee createEmployeeRequest) {
		Employee foundEmployee = findEmployee(createEmployeeRequest.getId());
		remove(foundEmployee);
		Employee updatedEmployee = foundEmployee;
		if(createEmployeeRequest.getBirthDate() != null){
			updatedEmployee.setBirthDate(createEmployeeRequest.getBirthDate());
		}
		if(createEmployeeRequest.getPinCode() != null){
			updatedEmployee.setPinCode(createEmployeeRequest.getPinCode());
		}
		this.employeeList.add(updatedEmployee);
		logger.debug("After updating employee");
		showEmployeeList();
		return updatedEmployee;
	}

	@Override
	public Boolean removeEmployee(String employeeId) {
//		return this.employeeList.removeIf(emp -> emp.getId().equals(employeeId));
		Employee foundEmployee = findEmployee(employeeId);
		remove(foundEmployee);
		Employee updatedEmployee = foundEmployee;
		updatedEmployee.setIsActive(Boolean.FALSE);
		this.employeeList.add(updatedEmployee);
		logger.debug("After deleting employee");
		showEmployeeList();
		return true;

	}
	
	
	public Boolean isEmployeeAlreadyExist(Employee employee){
		logger.debug("checking emp with same details present or not {} " , this.employeeList.stream().anyMatch(emp -> emp.getEmail().equals(employee.getEmail()) && emp.getIsActive()));
		return this.employeeList.stream().anyMatch(emp -> emp.getEmail().equals(employee.getEmail()) && emp.getIsActive());
	}
	
	private void showEmployeeList(){
		this.employeeList.forEach(emp -> logger.debug("\n Employee {} " , emp));
	}

	@Override
	public Employee findEmployee(String employeeId) {
		return this.employeeList.stream().filter(emp -> emp.getId().equals(employeeId)).findFirst().get();
	}
	
	
	public void remove(Employee old){
		this.employeeList.remove(old);
	}

}
