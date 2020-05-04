package dev.sherpa.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.sherpa.entities.Employee;
import dev.sherpa.services.EmployeeService;
import dev.sherpa.services.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeLogin
 */
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmployeeService eserv = new EmployeeServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("username");
		String pword = request.getParameter("password");
		
		response.getWriter().append(uname);
		
		if(eserv.check(uname, pword)) {
			
			Employee employee = eserv.getEmployeeByUp(uname);
			int eid = employee.geteId();	
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			session.setAttribute("uid", eid);
			
			response.sendRedirect("eWelcome.html");
			
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
