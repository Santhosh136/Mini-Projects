package com.santhosh.pma.controllers;

import javax.validation.Valid;

import com.santhosh.pma.entities.Project;
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
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		model.addAttribute("project", new Project());
		model.addAttribute("employees", employeeService.findAll());
		return "projects/project-form";
	}
	
	@PostMapping("/save")
	public String saveProject(@Valid Project project, Errors errors) {
		if(errors.hasErrors()) {
			return "projects/project-form";
		}
		
		projectService.save(project);
		return "redirect:/projects/new";
	}
	
	@GetMapping("/display") 
	public String displayProjects(Model model) {
		model.addAttribute("projects", projectService.findAll());
		return "projects/project-display";
	}
}
