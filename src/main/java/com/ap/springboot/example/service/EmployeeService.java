package com.ap.springboot.example.service;

import java.util.List;
import java.util.UUID;

import com.ap.springboot.example.dto.EmployeeRequestDTO;
import com.ap.springboot.example.dto.EmployeeResponseDTO;

public interface EmployeeService {

	public List<EmployeeResponseDTO> getAll();
	
	public EmployeeResponseDTO save(EmployeeRequestDTO employeeDTO);
	
	public EmployeeResponseDTO findById(UUID employeeId);
	
	public EmployeeResponseDTO update(EmployeeRequestDTO employeeDTO, UUID employeeId);
	
	public void delete(UUID employeeId);
}
