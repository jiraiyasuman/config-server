package com.banking_employeeapp.controller;



import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking_employeeapp.dto.ApiResponseDto;
import com.banking_employeeapp.dto.EmployeeDto;
import com.banking_employeeapp.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("bankingapp/employees")
@Tag(
		name ="CRUD Rest API for Employee Resource",
		description = "Create employee, Update employee, Get Employee By Id, Get All Employees, Delete Empployees by id"
		)
public class EmployeeController {

	private EmployeeService employeeService;
	//private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	// save employee details 
	// http://localhost:8080/bankingapp/employees/save
	 @PostMapping("save")
	 @Operation(
				summary ="Create Empployee REST API",
				description = "Create Employee REST API is used to save employee details in a database"
				)
		@ApiResponse(
				responseCode = "201",
				description = "HTTP STATUS 201 created"
				)
	ResponseEntity<EmployeeDto> saveUser(@RequestBody @Valid EmployeeDto employee){
		employeeService.saveEmployee(employee);
		return ResponseEntity.ok(employee);
	}
	// fetch all employee details 
		// http://localhost:8080/bankingapp/employees/fetch
	 @Operation(
				summary ="Get All Empployees REST API",
				description = "Get All Employee REST API is used to fetch all employee details from a database"
				)
		@ApiResponse(
				responseCode = "201",
				description = "HTTP STATUS 201 created"
				)
	 @GetMapping("fetch")
	 ResponseEntity<List<EmployeeDto>> getAllEmployee(){
		 List<EmployeeDto> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	 }
	// get employee details  by  their id
		// http://localhost:8080/bankingapp/employees/fetch/{id}
	 @Operation(
				summary ="Get Empployees REST API by id",
				description = "Get Employee REST API by their id is used to fetch employee details from a database"
				)
		@ApiResponse(
				responseCode = "201",
				description = "HTTP STATUS 201 created"
				)
	 @GetMapping("fetch/{id}")
	 ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable Long id){
		 ApiResponseDto  employee = employeeService.getEmployeeById(id);
		 return ResponseEntity.ok(employee);
	 }
	// update employee details  by  their id
			// http://localhost:8080:/bankingapp/employees/update/{id}
		 @Operation(
					summary ="Update Empployees REST API by id",
					description = "Update Employee REST API by their id is used to update employee details from a database"
					)
			@ApiResponse(
					responseCode = "201",
					description = "HTTP STATUS 201 created"
					)
		 @PutMapping("update/{id}")
		 ResponseEntity<EmployeeDto> updateEmployeeDetails(@PathVariable("id") Long id, @RequestBody @Valid EmployeeDto employee){
			 EmployeeDto updatedEmployeeDto = employeeService.updateEmployeeById(employee);
			 return ResponseEntity.ok(updatedEmployeeDto);
		 }
		// delete employee details  by  their id
					// http://localhost:8080/bankingapp/employees/delete/{id}
				 @Operation(
							summary ="Delete Empployees REST API by id",
							description = "Delete Employee REST API by their id is used to fetch employee details from a database"
							)
					@ApiResponse(
							responseCode = "201",
							description = "HTTP STATUS 201 created"
							)
				 @DeleteMapping("delete/{id}")
		 ResponseEntity<String> deleteEmployeeDetails(@PathVariable Long id){
			 employeeService.deleteEmployeeById(id);
			 return ResponseEntity.ok("Employee details are deleted successfully");
		 }
	
	
}
