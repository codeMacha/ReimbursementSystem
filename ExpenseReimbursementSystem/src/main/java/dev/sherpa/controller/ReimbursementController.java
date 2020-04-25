package dev.sherpa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.sherpa.entities.Reimbursement;
import dev.sherpa.services.ReimbursementService;
import dev.sherpa.services.ReimbursementServiceImpl;

public class ReimbursementController {
	
	ReimbursementService rserv = new ReimbursementServiceImpl();
	
	public void getAllReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		List<Reimbursement> reimbursementlist = rserv.retrieveAllReimbursement();
		PrintWriter pw = response.getWriter();
		
		String json = gson.toJson(reimbursementlist);
		pw.append(json);
	}
	
	public void addReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String body = request.getReader().lines().reduce("", (accumulator,actual) -> accumulator+actual);
		Gson gson = new Gson();
		Reimbursement t = gson.fromJson(body, Reimbursement.class);
		rserv.createReimbursement(t);
		response.getWriter().append("Success!");
	}
	
	public void submittedReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(rserv.retrieveSubmittedReimbursement());
		response.getWriter().append(json);
	}
	
	public void approvedReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(rserv.retrieveApprovedReimbursement());
		response.getWriter().append(json);
	}
	
	public void rejectedReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(rserv.retrieveRejectedReimbursement());
		response.getWriter().append(json);
	}
	
	public void approveReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String json = request.getReader().lines().reduce("", (accumulator,actual) -> accumulator+actual);
		Reimbursement reimbursement = gson.fromJson(json, Reimbursement.class);
		rserv.approveReimbursement(reimbursement);		
		response.getWriter().append("Successfully updated");
	}
	
	public void rejectReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String json = request.getReader().lines().reduce("", (accumulator,actual) -> accumulator+actual);
		Reimbursement reimbursement = gson.fromJson(json, Reimbursement.class);
		rserv.rejectReimbursement(reimbursement);		
		response.getWriter().append("Successfully updated");
	}

	
}
