package com.banking_microservices_department.service;

import java.util.List;

import com.banking_microservices_department.DTo.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDepartment(DepartmentDto departmentDto);  // save the department 
	
	List<DepartmentDto> getAllDepartment(); // get all the lists of department
	
	DepartmentDto getDepartmentById(Long id);  // get department by id
	
	DepartmentDto updateDepartmentById(DepartmentDto departmentDto); // updates the lists by id
	
	void deleteDepartmentById(Long id); // delete the lists by id
	
	DepartmentDto getDepartmentDetailsByDepartmentCode(String departmentCode);
}
