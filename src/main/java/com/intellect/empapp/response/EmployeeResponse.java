package com.intellect.empapp.response;

import java.util.Map;

public class EmployeeResponse {
	
	private String resMsg;
	
	private String userId;
	
	private Map<String,String> valErrors;

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Map<String, String> getValErrors() {
		return valErrors;
	}

	public void setValErrors(Map<String, String> valErrors) {
		this.valErrors = valErrors;
	}
	
	

}
