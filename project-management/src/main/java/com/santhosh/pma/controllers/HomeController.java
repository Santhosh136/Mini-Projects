package com.santhosh.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.santhosh.pma.services.EmployeeService;
import com.santhosh.pma.services.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
Home controller for rendering home page
*/
@Controller
public class HomeController {
	@Value(value = "${version}")
	private String version;

	@Autowired
	ProjectService projectService;

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		model.addAttribute("version", version);
		model.addAttribute("employeeProjectCount", employeeService.employeeProjects());
		model.addAttribute("chartData", new ObjectMapper().writeValueAsString(projectService.getChartData()));
		model.addAttribute("projects", projectService.findAll());
		return "index";
	}

	@GetMapping(value="/hello")
	@ResponseBody
	public String sayHello() {
		return new String("Hello Java");
	}
	
}
