package com.banking_employeeapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.banking_employeeapp.dto.EmployeeDto;
import com.banking_employeeapp.entity.Employee;

@Mapper
public interface EmployeeAutoMapper {
	EmployeeAutoMapper MAPPER = Mappers.getMapper(EmployeeAutoMapper.class);
	Employee mapToEmployee(EmployeeDto employeeDto);  // convert DTO object into JPA entity
	EmployeeDto mapToEmployeeDto(Employee employee); // convert JPA entity to DTO object
}
