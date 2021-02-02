package com.santhosh.pma.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.santhosh.pma.dto.EmployeeProject;
import com.santhosh.pma.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	@Override
	List<Employee> findAll();

	
	@Query(nativeQuery = true, value="SELECT e.first_name AS firstName, e.last_name AS lastName, e.email AS email, COUNT(pe.employee_id) AS projectCount "+
	"FROM employee AS e "+
	"LEFT JOIN project_employee AS pe "+
	"ON e.employee_id = pe.employee_id "+
	"GROUP BY e.first_name "+
	"ORDER BY 4 DESC")
	List<EmployeeProject> employeeProjects();
	
}
