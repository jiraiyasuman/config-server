package com.banking_employeeapp.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.banking_employeeapp.dto.DepartmentDto;

@FeignClient(name="DEPARTMENT-SERVICE")
public interface ApiClient {
	@GetMapping("department/fetchCode/{departmentCode}")
	DepartmentDto getDepartmentByCode(@PathVariable("departmentCode") String departmentCode);
}