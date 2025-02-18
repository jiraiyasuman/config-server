package com.banking_employeeapp.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
@Data
public class EmployeeDto {

	
	private Long id;
	@NotEmpty
	private String firstName; // first name should not be null
	@NotEmpty
	private String lastName; // last name should not be null
	@NotEmpty@Email
	private String email; // email should not be null/invalid
	@NotEmpty
	private String departmentCode; // department Code should not be null/blank
}
