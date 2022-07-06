package com.ap.springboot.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {
	
	@NotBlank
	@Size(max = 15, message = "Employee name is too long. Max=15") 
	private String name;
	
	@NotBlank
	@Size(max = 20, message = "Employee role name is too long. Max=20")
	private String role;
}
