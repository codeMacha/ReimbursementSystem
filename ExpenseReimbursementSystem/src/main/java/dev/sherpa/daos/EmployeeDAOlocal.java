package dev.sherpa.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.sherpa.entities.Employee;

public class EmployeeDAOlocal implements EmployeeDAO{

	private static Map<Integer,Employee> employee_table = new HashMap<Integer,Employee>();
	private int idGenerator = 1;
	
	public EmployeeDAOlocal() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employee createEmployee(Employee employee) {
		employee.seteId(idGenerator);
		idGenerator++;
		
		employee_table.put(employee.geteId(), employee);
		return employee;
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employee_table.get(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> empList = new ArrayList<Employee>(employee_table.values());
		return empList;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		employee_table.put(employee.geteId(), employee);
		return employee;
	}

	@Override
	public boolean removeEmployee(Employee employee) {
		employee_table.remove(employee.geteId());
		return true;
	}

	@Override
	public Employee getEmployeeByuandpname(String uname) {
		return null;
	}

	@Override
	public boolean checkUsernamePassword(String uname, String pword) {
		// TODO Auto-generated method stub
		return false;
	}

}
