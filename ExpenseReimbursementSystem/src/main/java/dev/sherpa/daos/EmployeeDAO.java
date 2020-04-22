package dev.sherpa.daos;

import java.util.List;

import dev.sherpa.entities.Employee;

public interface EmployeeDAO {

	// create
	Employee createEmployee(Employee employee);
	
	// read
	Employee getEmployeeById(int id);
	List<Employee> getAllEmployee();
	
	// update
	Employee updateEmployee(Employee employee);
	
	// delete
	boolean removeEmployee(Employee employee);
}
