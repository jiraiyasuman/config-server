package com.banking_microservices_department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking_microservices_department.DTo.DepartmentDto;
import com.banking_microservices_department.entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	DepartmentDto getByDepartmentCode(String departmentCode);
}
