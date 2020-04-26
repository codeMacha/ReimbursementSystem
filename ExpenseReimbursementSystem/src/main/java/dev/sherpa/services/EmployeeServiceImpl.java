package dev.sherpa.services;

import java.util.List;

import dev.sherpa.entities.Employee;
import dev.sherpa.daos.EmployeeDAO;
import dev.sherpa.daos.EmployeeDAOMaria;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDAO edao = new EmployeeDAOMaria();

	@Override
	public Employee getEmployeeByUp(String uname) {
		return edao.getEmployeeByuandpname(uname);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return edao.getAllEmployee();
	}
	
	public boolean check(String uname, String pword) {
		return edao.checkUsernamePassword(uname, pword);
	}

}
