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

import com.santhosh.pma.entities.Project;
import com.santhosh.pma.repositories.EmployeeRepository;
import com.santhosh.pma.repositories.ProjectRepository;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		model.addAttribute("project", new Project());
		model.addAttribute("employees", employeeRepository.findAll());
		return "projects/project-form";
	}
	
	@PostMapping("/save")
	public String saveProject(@Valid Project project, Errors errors) {
		if(errors.hasErrors()) {
			return "projects/project-form";
		}
		
		projectRepository.save(project);
		
//		List<Employee> employees = project.getEmployees();
//		for(Employee employee: employees) {
//			employee.setProject(project);
//			employeeRepository.save(employee);
//		}
		
		return "redirect:/projects/new";
	}
	
	@GetMapping("/display") 
	public String displayProjects(Model model) {
		List<Project> projects = projectRepository.findAll();
		model.addAttribute("projects", projects);
		return "projects/project-display";
	}
}
