package com.banking_microservices_department.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.banking_microservices_department.DTo.DepartmentDto;
import com.banking_microservices_department.entity.Department;
@Mapper
public interface DepartmentMapper {

	DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);
	Department mapToDepartment(DepartmentDto departmentDto);  // converts DTO objects into JPA entities
	DepartmentDto mapDepartmentDto(Department department);  // converts JPA entities into DTO objects
}
