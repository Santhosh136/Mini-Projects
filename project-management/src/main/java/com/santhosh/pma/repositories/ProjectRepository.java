package com.santhosh.pma.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.santhosh.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	@Override
	List<Project> findAll();
}
