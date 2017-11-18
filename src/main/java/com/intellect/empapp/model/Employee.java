package com.intellect.empapp.model;

import java.io.Serializable;
import java.sql.Date;

public class Employee implements Serializable{

	private String id;
	
	private String fName;
	
	private String lName;
	
	private String email;
	
	private Integer pinCode;
	
	private Date birthDate;
	
	private Boolean isActive;

	public Employee(){
		
	}
	
	public Employee(String employeeId){
		id = employeeId;
	}
	public Employee(String id, String fName, String lName, String email, Integer pinCode, Date birthDate,
			Boolean isActive) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pinCode = pinCode;
		this.birthDate = birthDate;
		this.isActive = isActive;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", pinCode="
				+ pinCode + ", birthDate=" + birthDate + ", isActive=" + isActive + "]";
	}
	
}
