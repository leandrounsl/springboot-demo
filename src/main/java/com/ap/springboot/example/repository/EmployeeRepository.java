package com.ap.springboot.example.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.springboot.example.model.Employee;

// Spring Data JPA repositories are interfaces with methods supporting creating, reading, updating, 
// and deleting records against a back end data store.
// Spring makes accessing data easy. By simply declaring the following EmployeeRepository 
// interface we automatically will be able to:
// * Create new Employees
// * Update existing ones
// * Delete Employees
// * Find Employees (one, all, or search by simple or complex properties)
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}
