package com.santhosh.pma.controllers;

import javax.validation.Valid;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.santhosh.pma.entities.Employee;
import com.santhosh.pma.services.EmployeeService;
import com.santhosh.pma.services.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("projects", projectService.findAll());
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@Valid Employee employee, Errors errors) {
		if(errors.hasErrors()) {
			System.out.println("Error occured"+errors);
			return "employees/employee-form";
		}
		
		employeeService.save(employee);
		return "redirect:/employees/new";
	}
	
	@GetMapping("/display") 
	public String displayEmployees(Model model) throws JsonProcessingException {
		model.addAttribute("employees", employeeService.findAll());
		return "employees/employee-display";
	}

}
