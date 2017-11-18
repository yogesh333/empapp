package com.intellect.empapp.validation;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.intellect.empapp.model.Employee;
import com.intellect.empapp.response.EmployeeResponse;

public class EmployeeValidation {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeValidation.class);

	public static EmployeeResponse isInvalidcreateEmployeeRequest(Employee createEmployeeRequest) {

		EmployeeResponse createEmployeeResponse = new EmployeeResponse();
		if (null == createEmployeeRequest) {
			createEmployeeResponse.setResMsg("Employee creation failed, required parameters are missing");
			addErrr(createEmployeeRequest, createEmployeeResponse);
			return createEmployeeResponse;
		}else{
			addErrr(createEmployeeRequest, createEmployeeResponse);
			return createEmployeeResponse;
		}
				
	}

	public static void addErrr(Employee createEmployeeRequest,EmployeeResponse createEmployeeResponse){
		Map<String, String> errors = new HashMap<String, String>();
		if (null == createEmployeeRequest.getfName()) {
				errors.put("First Name", "Required Parameter Missing");
		}
		if (null == createEmployeeRequest.getlName()) {
			errors.put("Last Name", "Required Parameter Missing");
		}
		if (null == createEmployeeRequest.getEmail()) {
			errors.put("Email", "Required Parameter Missing");
		}
		if (null == createEmployeeRequest.getBirthDate()) {
			errors.put("Birth Date", "Required Parameter Missing");
		}
		createEmployeeResponse.setValErrors(errors);
	}
}
