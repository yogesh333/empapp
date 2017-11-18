package com.intellect.empapp.dao;

import com.intellect.empapp.model.Employee;

public interface EmployeeDao {
  public Employee saveEmployee(Employee createEmployeeRequest);
  public Employee updateEmployee(Employee createEmployeeRequest);
  public Boolean removeEmployee(String employeeId);
  public Boolean isEmployeeAlreadyExist(Employee employee);
  public Employee findEmployee(String employeeId);
  
}
