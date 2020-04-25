package dev.sherpa.daos;

import java.util.List;

import dev.sherpa.entities.Reimbursement;

public interface ReimbursementDAO {

	//CREATE
	Reimbursement createReimbursement(Reimbursement reimbursement);
	
	//READ
	Reimbursement getReimbursementById(int id);
	List<Reimbursement> getReimbursementbyemployeeId(int id);
	List<Reimbursement> getAllReimbursement();
	List<Reimbursement> getAllReimbursementbyStatus(String status);
	
	//UPDATE
	Reimbursement updateReimbursement(Reimbursement reimbursement);
	
	//DELETE
	boolean removeReimbursement(Reimbursement reimbursement);

	
	
	
	
}
