package dev.sherpa.daotests;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.sherpa.daos.EmployeeDAO;
import dev.sherpa.daos.EmployeeDAOMaria;
import dev.sherpa.entities.Employee;

public class EmployeeDAOmariatest {

private static EmployeeDAO edao = new EmployeeDAOMaria();
	
	@Test
	public void createEmployee() {
		Employee employee = new Employee();
		employee.setName("rahul");
		employee.setUsername("Cryme");
		employee.setPassword("ariver");
		employee.setManagerId(2);
		edao.createEmployee(employee);
		
		System.out.println(employee);
	}
	
	@Test
	public void getEmployee() {
		System.out.println(edao.getEmployeeById(1));
	}
	
	@Test
	public void updateEmployee() {
		Employee employee = edao.getEmployeeById(1);
		employee.setUsername("superman");
		edao.updateEmployee(employee);
		System.out.println(employee);
	}

}
