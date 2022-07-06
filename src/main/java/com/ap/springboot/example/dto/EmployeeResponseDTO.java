package com.ap.springboot.example.dto;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EmployeeResponseDTO extends EmployeeRequestDTO {

	private UUID employeeId;

	@Builder
	public EmployeeResponseDTO(String name, String role, UUID employeeId) {
		super(name, role);
		this.employeeId = employeeId;		
	}	
}
