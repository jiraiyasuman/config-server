package com.banking_employeeapp.repositry;

import org.springframework.data.jpa.repository.JpaRepository;



import com.banking_employeeapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
