package com.banking_microservices_department.controller;


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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking_microservices_department.DTo.DepartmentDto;
import com.banking_microservices_department.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@Tag(
		name="This is a Restful API for Departments",
		description =" Restful web services for CRUD operations "
		)
@Slf4j
@RestController
@RequestMapping("department")
public class DepartmentController {

	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	private DepartmentService departmentService;

	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	@Operation(
			summary ="This is a Department Spring Restful API",
			description="saves the department details"
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP STATUS 201 created"
			)
	
	// saves the department
	// http://localhost:8081/department/save
	@PostMapping("save")
	ResponseEntity<DepartmentDto> saveDepartment(@RequestBody @Valid DepartmentDto departmentDto){
		DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
		return ResponseEntity.ok(savedDepartmentDto);
	}
	@Operation(
			summary ="This is a Department Spring Restful API",
			description = "gets all the department details "
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP STATUS 201 created"
			)
	// fetches the department
		// http://localhost:8081/department/fetch
	@GetMapping("fetch")
	ResponseEntity<List<DepartmentDto>> getAllDepartents(){
		List<DepartmentDto> lists = departmentService.getAllDepartment();
		return ResponseEntity.ok(lists);
	}
	@Operation(
			summary ="This is a Department Spring Restful API",
			description = "gets the department detail by the id "
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP STATUS 201 created"
			)
	// fetches the department by id
		// http://localhost:8081/department/fetch/1
	@GetMapping("fetch/{id}")
	ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long id){
		DepartmentDto departmentDto = departmentService.getDepartmentById(id);
		return ResponseEntity.ok(departmentDto);
	}
	@Operation(
			summary ="This is a Department Spring Restful API",
			description = "gets the department detail by the id "
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP STATUS 201 created"
			)
	// fetches the department by id
		// http://localhost:8081/department/fetch/1
	@GetMapping("fetchCode/{departmentCode}")
	ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("departmentCode") String departmentCode){
		DepartmentDto departmentDto = departmentService.getDepartmentDetailsByDepartmentCode(departmentCode);
		return ResponseEntity.ok(departmentDto);
	}
	
	
	@Operation(
			summary ="This is a Department Spring Restful API",
			description = "update the department detail by the id "
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP STATUS 201 created"
			)
	// updates the department by id
		// http://localhost:8081/department/update/1
	@PutMapping("update/{id}")
	ResponseEntity<DepartmentDto> updateDepartmentDto(@PathVariable("id") Long id, @RequestBody @Valid DepartmentDto departmentDto ){
		DepartmentDto updatedDepartmentDto = departmentService.updateDepartmentById(departmentDto);
		return ResponseEntity.ok(departmentDto);
	}
	@Operation(
			summary ="This is a Department Spring Restful API",
			description = "delete the department detail by the id "
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP STATUS 201 created"
			)
	// delete the department
		// http://localhost:8081/department/delete/1
	@DeleteMapping("delete/{id}")
	ResponseEntity<String> deleteDepartmentById(@PathVariable("id") Long id){
		departmentService.deleteDepartmentById(id);
		return ResponseEntity.ok("Department deleted successfully");
	}
}
