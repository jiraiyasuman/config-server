package com.banking_employeeapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last-name")
	private String lastName;
	@Column(name="email")
	private String email;
	private String departmentCode;
}
