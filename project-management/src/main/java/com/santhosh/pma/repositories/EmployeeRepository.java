package com.santhosh.pma.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.santhosh.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	@Override
	List<Employee> findAll();
}
