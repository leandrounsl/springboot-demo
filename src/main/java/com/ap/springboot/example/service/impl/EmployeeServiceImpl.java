package com.ap.springboot.example.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ap.springboot.example.dto.EmployeeRequestDTO;
import com.ap.springboot.example.dto.EmployeeResponseDTO;
import com.ap.springboot.example.exception.EmployeeNotFoundException;
import com.ap.springboot.example.model.Employee;
import com.ap.springboot.example.repository.EmployeeRepository;
import com.ap.springboot.example.service.EmployeeService;

// @Service: We mark beans with @Service to indicate that they're holding the business logic
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	private EmployeeResponseDTO toDTO(Employee employee) {
		return EmployeeResponseDTO.builder().employeeId(employee.getId())
				.name(employee.getName()).role(employee.getRole()).build();
	}
	
	private Employee toEntity(EmployeeRequestDTO employeeDTO) {
		return Employee.builder().name(employeeDTO.getName()).role(employeeDTO.getRole()).build();
	}
	
	@Override
	public List<EmployeeResponseDTO> getAll() {
		return employeeRepository.findAll().stream().map(em -> toDTO(em)).collect(Collectors.toList());
	}

	@Override
	public EmployeeResponseDTO save(EmployeeRequestDTO employeeDTO) {
		Employee newEmployee = this.employeeRepository.save(toEntity(employeeDTO));
		return toDTO(newEmployee);
	}

	@Override
	public EmployeeResponseDTO findById(UUID employeeId) {
		Employee employee = this.employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException(employeeId));
		return toDTO(employee);
	}

	@Override
	public EmployeeResponseDTO update(EmployeeRequestDTO employeeDTO, UUID employeeId) {
		return this.employeeRepository.findById(employeeId).map(employee -> {
			employee.setName(employeeDTO.getName());
			employee.setRole(employeeDTO.getRole());
			return toDTO(employeeRepository.save(employee));
		}).orElseGet(() -> {
			Employee newEmployee = toEntity(employeeDTO);
			newEmployee.setId(employeeId);
			return toDTO(this.employeeRepository.save(newEmployee));
		});
	}

	@Override
	public void delete(UUID employeeId) {
		Employee employee = this.employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException(employeeId));
		this.employeeRepository.delete(employee);
	}

}
