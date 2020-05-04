package dev.sherpa.servicetests;

import static org.junit.Assert.*;

import dev.sherpa.entities.Reimbursement;
import dev.sherpa.services.ReimbursementService;
import dev.sherpa.services.ReimbursementServiceImpl;

import org.junit.Test;

public class ReimbursementServicetest {

	ReimbursementService rserv = new ReimbursementServiceImpl();
	
	@Test
	public void create() {
		Reimbursement r = new Reimbursement();
		r.setAmount(2000);
		r.setDescription("new computer");
		r.setRequesterId(1);
		rserv.createReimbursement(r);
		System.out.println(r);
	}
	
	@Test
	public void reject() {
		Reimbursement r = rserv.getReimbursemnetById(1);
		rserv.updateReimbursement(r);
	}
	
	@Test
	public void getall() {
		System.out.println(rserv.retrieveAllReimbursement());
	}
	
	@Test
	public void test() {
		Reimbursement r = rserv.getReimbursemnetById(2);
		System.out.println(r);
		rserv.updateReimbursement(r);
	}

}
