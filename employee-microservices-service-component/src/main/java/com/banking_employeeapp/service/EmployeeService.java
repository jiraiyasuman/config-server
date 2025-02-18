package com.banking_employeeapp.service;

import java.util.List;

import com.banking_employeeapp.dto.ApiResponseDto;
import com.banking_employeeapp.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto employeeDto);    // saves the employee
	
	List<EmployeeDto> getAllEmployees();   // gets all list of employees
	
	ApiResponseDto getEmployeeById(Long id);  // gets employee details by id
	
	EmployeeDto updateEmployeeById(EmployeeDto employeeDto);  // update employee details by id
	
	void deleteEmployeeById(Long id);  // delete employee by id
}
