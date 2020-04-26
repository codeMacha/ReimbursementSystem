package dev.sherpa.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sherpa.controller.ReimbursementController;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    ReimbursementController rcontroller = new ReimbursementController();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		switch(uri) {
		
		case "/ExpenseReimbursementSystem/api/reimbursements" : rcontroller.getAllReimbursement(request, response); break;
		case "/ExpenseReimbursementSystem/api/emplreimbursements" : rcontroller.getAllReimbursementByempId(request, response); break;
		case "/ExpenseReimbursementSystem/api/addreimbursement" : rcontroller.addReimbursement(request, response); break;
		case "/ExpenseReimbursementSystem/api/submitteddreimbursements" : rcontroller.submittedReimbursements(request, response); break;
		case "/ExpenseReimbursementSystem/api/update" : rcontroller.changeReimbursement(request, response);; break;

		
		default : response.getWriter().append("your request uri did not match anything");break;
		
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
