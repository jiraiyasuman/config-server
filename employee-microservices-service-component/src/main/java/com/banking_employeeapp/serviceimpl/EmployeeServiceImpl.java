package com.banking_employeeapp.serviceimpl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.banking_employeeapp.dto.ApiResponseDto;
import com.banking_employeeapp.dto.DepartmentDto;
import com.banking_employeeapp.dto.EmployeeDto;
import com.banking_employeeapp.entity.Employee;
import com.banking_employeeapp.mapper.EmployeeAutoMapper;
import com.banking_employeeapp.repositry.EmployeeRepository;
import com.banking_employeeapp.service.ApiClient;
import com.banking_employeeapp.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	private ModelMapper modelMapper;
	private EmployeeRepository employeeRepository;
	
	//private RestTemplate restTemplate;
	//private WebClient webClient;
	private ApiClient apiClient;
	
	
	@Autowired
	public EmployeeServiceImpl(ModelMapper modelMapper, EmployeeRepository employeeRepository, ApiClient apiClient) {
		super();
		this.modelMapper = modelMapper;
		this.employeeRepository = employeeRepository;
		this.apiClient = apiClient;
	}
	
	/*
	 * @Autowired public EmployeeServiceImpl(ModelMapper modelMapper,
	 * EmployeeRepository employeeRepository, WebClient webClient) { super();
	 * this.modelMapper = modelMapper; this.employeeRepository = employeeRepository;
	 * this.webClient = webClient; }
	 */
	@Transactional
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeAutoMapper.MAPPER.mapToEmployee(employeeDto); // converts from Dto to Jpa entities
		
		Employee savedEmployee = employeeRepository.save(employee); // save the employee details in the database
		
		EmployeeDto finalEmployeeDto = EmployeeAutoMapper.MAPPER.mapToEmployeeDto(savedEmployee);
		
		return finalEmployeeDto;
	}

	

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employee = employeeRepository.findAll();
		
		return employee.stream().map((user) -> EmployeeAutoMapper.MAPPER.mapToEmployeeDto(user)).collect(Collectors.toList());
	}

	@Override
	public ApiResponseDto getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).get();
		
		
		// call Department Service to fetch the Department details
		
		//ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8082/department/fetchCode/"+employee.getDepartmentCode(), DepartmentDto.class);
		
		//DepartmentDto departmentDto = responseEntity.getBody();
		
		/*
		 * DepartmentDto departmentDto = webClient.get()
		 * .uri("http://localhost:8082/department/fetchCode/"+employee.getDepartmentCode
		 * ()) .retrieve() .bodyToMono(DepartmentDto.class) .block();
		 */
		DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());
		if(employee == null) {
			throw new RuntimeException("User id is not found"+id);
		}
		EmployeeDto employeeDto = EmployeeAutoMapper.MAPPER.mapToEmployeeDto(employee);
		ApiResponseDto apiResponseDto = new ApiResponseDto();
		apiResponseDto.setDepartmentDto(departmentDto);
		apiResponseDto.setEmployeeDto(employeeDto);
		
		return apiResponseDto;
	}
	
	@Transactional
	@Override
	public EmployeeDto updateEmployeeById(EmployeeDto employeeDto) {
		Employee getUser = EmployeeAutoMapper.MAPPER.mapToEmployee(employeeDto);
		// get employee by id
		Employee employee = employeeRepository.findById(getUser.getId()).get();
		if(employee == null) {
			throw new RuntimeException("Employee id is not found"+getUser.getId());
		}
		employee.setFirstName(getUser.getFirstName());
		employee.setLastName(getUser.getLastName());
		employee.setEmail(getUser.getEmail());
		Employee updatedEmployee = employeeRepository.save(getUser);
		EmployeeDto finalEmployeeDto = EmployeeAutoMapper.MAPPER.mapToEmployeeDto(updatedEmployee);
		return finalEmployeeDto;
	}

	@Transactional
	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
		
	}

}
