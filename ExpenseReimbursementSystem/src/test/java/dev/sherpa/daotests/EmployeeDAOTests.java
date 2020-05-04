package dev.sherpa.daotests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.sherpa.daos.EmployeeDAO;
import dev.sherpa.daos.EmployeeDAOlocal;

import dev.sherpa.entities.Employee;

public class EmployeeDAOTests {

	private EmployeeDAO edao = new EmployeeDAOlocal();
	
	@Before
	public void setup() {
		Employee employee = new Employee();
		employee.setName("Pasang Sherpa");
		employee.setUsername("mlala");
		employee.setPassword("password");
		employee.setManagerId(1);
		edao.createEmployee(employee);
		
		Employee employee1 = new Employee();
		employee1.setName("Rahul perera");
		employee1.setUsername("rpere");
		employee1.setPassword("worddd");
		employee1.setManagerId(3);
		edao.createEmployee(employee1);	
	}
	
	@Test
	public void create() {
		Employee employee = new Employee();
		edao.createEmployee(employee);
		employee.setName("Pasang Sherpa");
		employee.setUsername("mlala");
		employee.setPassword("password");
		employee.setManagerId(1);
		System.out.println(employee);
	}
	
	@Test
	public void getEmployee() {
		System.out.println(edao.getEmployeeById(1));
	}
	
	@Test
	public void getallEmployee() {
		List<Employee> elist = edao.getAllEmployee();
		System.out.println(elist);
	}
	
	@Test
	public void delete() {
		Employee employee = edao.getEmployeeById(1);
		System.out.println(edao.removeEmployee(employee));
	}

}
