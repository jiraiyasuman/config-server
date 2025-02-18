package com.banking_microservices_department.DTo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;


//import lombok.Data;
/*
 * private Long id;
 * 
 * @NotEmpty private String departmentName; // department name should not be
 * null
 * 
 * @NotEmpty private String departmentCode; // department code should not be
 * null
 * 
 * @NotEmpty private String departmentDescription; // department code should not
 * be null
 */
public record DepartmentDto(Long id,@Schema(
        description = "Department Name"
) @NotEmpty(message = "department name should not be blank/whitespace") String departmentName,@Schema(
        description = "Department Code"
) @NotEmpty(message = "department code should not be blank/whitespace") String departmentCode,@Schema(
        description = "Department description"
) @NotEmpty(message = "department name should not be blank/whitespace") String departmentDescription) {}