package dev.sherpa.daotests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dev.sherpa.entities.Reimbursement;
import dev.sherpa.daos.ReimbursementDAO;
import dev.sherpa.daos.ReimbursementDAOlocal;

public class ReimbursementDAOtest {
	
	private static ReimbursementDAO rdao = new ReimbursementDAOlocal();
	
	@Before
	public void setup() {
		Reimbursement reimbursement = new Reimbursement(0, 500, "paid for office", 1, "denied");
		rdao.createReimbursement(reimbursement);
		
		Reimbursement reimbursement1 = new Reimbursement(0, 100, "pencils", 2, "approved");
		rdao.createReimbursement(reimbursement1);
		
		Reimbursement reimbursement2 = new Reimbursement(0, 200, "papaer", 1, "approved");
		rdao.createReimbursement(reimbursement2);
		
		Reimbursement reimbursement3 = new Reimbursement(0, 600, "printer", 1, "denied");
		rdao.createReimbursement(reimbursement3);
	}
	
	@Test
	public void printOut() {
		System.out.println(rdao.getAllReimbursement());
	}
	
	@Test
	public void printOutbyStatus() {
		System.out.println(rdao.getAllReimbursementbyStatus("approved"));
	}
	
	@Test
	public void deleteReimbursement() {
		System.out.println(rdao.removeReimbursement(rdao.getReimbursementById(1)));
	}
	
	@Test
	public void create() {
		Reimbursement reimbursement = new Reimbursement(0, 500, "paid for office", 1, "");
		rdao.createReimbursement(reimbursement);
		
		System.out.println(reimbursement);
	}

}
