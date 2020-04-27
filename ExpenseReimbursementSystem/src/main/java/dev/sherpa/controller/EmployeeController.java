package dev.sherpa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.sherpa.entities.Employee;
import dev.sherpa.services.EmployeeService;
import dev.sherpa.services.EmployeeServiceImpl;

public class EmployeeController {
	
	private EmployeeService eserv = new EmployeeServiceImpl();

	public void getEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String uname = (String)request.getSession().getAttribute("username");
		Employee employee = eserv.getEmployeeByUp(uname);
		PrintWriter pw = response.getWriter();
		String json = gson.toJson(employee);
		pw.append(json);
	}
	
}
