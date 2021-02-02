package com.santhosh.pma.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.santhosh.pma.dto.ChartData;
import com.santhosh.pma.entities.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	@Override
	List<Project> findAll();

	@Query(nativeQuery = true, value = "select stage as label, count(stage) as value "+
	"from project group by stage")
	List<ChartData> getChartData();
}
