package dev.sherpa.daotests;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.sherpa.daos.ReimbursementDAOMaria;
import dev.sherpa.daos.ReimbursementDAO;
import dev.sherpa.entities.Reimbursement;

public class ReimbursementDAOmariatest {

	private static ReimbursementDAO rdao = new ReimbursementDAOMaria();
	
	@Test
	public void createReimbursement() {
		Reimbursement reimbursement = new Reimbursement();
		reimbursement.setDescription("over paid for the paper");
		reimbursement.setAmount(50);
		reimbursement.setRequesterId(2);
		reimbursement.setStatus("rejected");
		
		rdao.createReimbursement(reimbursement);
		System.out.println(reimbursement);
	}
	
	@Test
	public void getReimbursementbyId() {
		System.out.println(rdao.getReimbursementById(1));
	}
	
	@Test
	public void getallReimbursement() {
		System.out.println(rdao.getAllReimbursement());
	}
	
	@Test
	public void getallReimbursementbyStatus() {
		System.out.println(rdao.getAllReimbursementbyStatus("Approved"));
	}
	
	@Test
	public void changeReimbursement() {
		Reimbursement reimbursement = rdao.getReimbursementById(1);
		reimbursement.setAmount(1000);
		rdao.updateReimbursement(reimbursement);
		System.out.println(reimbursement);
	}

}
