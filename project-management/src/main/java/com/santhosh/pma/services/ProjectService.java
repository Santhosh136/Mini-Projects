package com.santhosh.pma.services;

import java.util.List;

import com.santhosh.pma.dto.ChartData;
import com.santhosh.pma.entities.Project;
import com.santhosh.pma.repositories.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    // field injection
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public void save(Project project) {
        projectRepository.save(project);
    }

	public List<ChartData> getChartData() {
		return projectRepository.getChartData();
	}

}
