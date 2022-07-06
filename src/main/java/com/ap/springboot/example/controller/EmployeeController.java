package com.ap.springboot.example.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ap.springboot.example.dto.EmployeeRequestDTO;
import com.ap.springboot.example.dto.EmployeeResponseDTO;
import com.ap.springboot.example.service.EmployeeService;

// @RestController: simplifies the controller implementation.
// We have routes for each operation (@GetMapping, @PostMapping, @PutMapping and @DeleteMapping, 
// corresponding to HTTP GET, POST, PUT, and DELETE calls).
@RestController
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<EmployeeResponseDTO> all() {
		return employeeService.getAll();
	}

	@PostMapping("/employees")
	public EmployeeResponseDTO newEmployee(@Valid @RequestBody EmployeeRequestDTO newEmployee) {
		return employeeService.save(newEmployee);
	}

	@GetMapping("/employees/{employeeId}")
	public EmployeeResponseDTO one(@PathVariable("employeeId") UUID employeeId) {
		return employeeService.findById(employeeId);
	}

	@PutMapping("/employees/{employeeId}")
	public EmployeeResponseDTO replaceEmployee(@Valid @RequestBody EmployeeRequestDTO newEmployee, @PathVariable("employeeId") UUID employeeId) {
		return employeeService.update(newEmployee, employeeId);
	}

	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId") UUID employeeId) {
		employeeService.delete(employeeId);
	}
}
