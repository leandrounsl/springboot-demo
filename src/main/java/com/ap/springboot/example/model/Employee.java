package com.ap.springboot.example.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity: Is a JPA annotation to make this object ready for storage in a JPA-based data store
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {

	@Id
	private UUID id;
	
	@Column(name = "name", length = 15)
	private String name;
	
	@Column(name = "role", length = 20)
	private String role;
	
	@Builder
	public Employee(String name, String role) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.role = role;
	}
}
