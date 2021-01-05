package com.santhosh.pma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.santhosh.pma.entities.Employee;
import com.santhosh.pma.repositories.EmployeeRepository;
import com.santhosh.pma.repositories.ProjectRepository;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("projects", projectRepository.findAll());
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@Valid Employee employee, Errors errors) {
		if(errors.hasErrors()) {
			System.out.println("Error occured"+errors);
			return "employees/employee-form";
		}
		
		employeeRepository.save(employee);
		return "redirect:/employees/new";
	}
	
	@GetMapping("/display") 
	public String displayEmployees(Model model) {
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employees", employees);
		return "employees/employee-display";
	}
}
