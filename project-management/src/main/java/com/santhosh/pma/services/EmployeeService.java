package com.santhosh.pma.services;

import java.util.List;

import com.santhosh.pma.dto.EmployeeProject;
import com.santhosh.pma.entities.Employee;
import com.santhosh.pma.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

	public List<EmployeeProject> employeeProjects() {
		return employeeRepository.employeeProjects();
	}
}
