package com.banking_employeeapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DepartmentDto {

	
	private Long id;
	@Schema(
			description = "Depatment Name"
			)
	@NotEmpty(message = "Department Name cannot be null/blank")
	private String departmentName;
	@Schema(
			description = "Department description"
			)
	@NotEmpty(message="Department Description cannot be null/blank")
	private String departmentDescription;
	@Schema(description = "Department Code")
	@NotEmpty(message="Department Code cannot be null/blank")
	private String departmentCode;
}
