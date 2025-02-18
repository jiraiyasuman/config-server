package com.banking_microservices_department.serviceimpl;

import java.util.List;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking_microservices_department.mapper.DepartmentMapper;
import com.banking_microservices_department.DTo.DepartmentDto;
import com.banking_microservices_department.entity.Department;
import com.banking_microservices_department.globaleceptionhandler.NotFoundException;
import com.banking_microservices_department.repository.DepartmentRepository;
import com.banking_microservices_department.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentRepository departmentRepository;
	@Autowired
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		Department department = DepartmentMapper.MAPPER.mapToDepartment(departmentDto);  // converts into JPA entities
		Department savedDepartment = departmentRepository.save(department); // saves the entity
		DepartmentDto savedDepartmentDto = DepartmentMapper.MAPPER.mapDepartmentDto(savedDepartment); // converts into Dto objects
		return savedDepartmentDto;
	}

	@Override
	public List<DepartmentDto> getAllDepartment() {
		List<Department> lists = departmentRepository.findAll();
		return lists.stream().map((user) -> DepartmentMapper.MAPPER.mapDepartmentDto(user)).collect(Collectors.toList());
	}

	@Override
	public DepartmentDto getDepartmentById(Long id) {
	    Department department = departmentRepository.findById(id).get();
	    if(department==null) {
	    	throw new NotFoundException("No details found with this id");
	    }
	    DepartmentDto departmentDto = DepartmentMapper.MAPPER.mapDepartmentDto(department);
		return departmentDto;
	}

	@Override
	public DepartmentDto updateDepartmentById(DepartmentDto departmentDto) {
		Department dept = DepartmentMapper.MAPPER.mapToDepartment(departmentDto);
		Department department = departmentRepository.findById(dept.getId()).get();
		if(department==null) {
	    	throw new NotFoundException("No details found with this id");
	    }
		department.setDepartmentName(dept.getDepartmentName());  // sets the new value of department name
		department.setDepartmentDescription(dept.getDepartmentDescription()); // sets the new value of department description
		department.setDepartmentCode(dept.getDepartmentCode());  // sets the new value of department code
		Department updatedDepartment = departmentRepository.save(department);
		DepartmentDto updatedDepartmentDto = DepartmentMapper.MAPPER.mapDepartmentDto(updatedDepartment);
		return updatedDepartmentDto;
	}

	@Override
	public void deleteDepartmentById(Long id) {
		Department department = departmentRepository.findById(id).get();
		if(department==null) {
	    	throw new NotFoundException("No details found with this id");
	    }
		departmentRepository.deleteById(id);  // deletes the department by id
	}

	@Override
	public DepartmentDto getDepartmentDetailsByDepartmentCode(String departmentCode) {
	//	Department department = DepartmentMapper.MAPPER.mapToDepartment(departmentDto);
		DepartmentDto getDepartment = departmentRepository.getByDepartmentCode(departmentCode);
		if(getDepartment==null) {
	    	throw new NotFoundException("No details found with this id");
	    }
		
		return getDepartment;
	}

}
