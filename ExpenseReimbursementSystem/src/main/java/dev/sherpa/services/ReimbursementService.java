package dev.sherpa.services;

import java.util.List;

import dev.sherpa.entities.Reimbursement;

public interface ReimbursementService {

	Reimbursement createReimbursement(Reimbursement reimbursement);
	Reimbursement approveReimbursement(Reimbursement reimbursement);
	Reimbursement rejectReimbursement(Reimbursement reimbursement);
	Reimbursement getReimbursemnetById(int id);
	
	List<Reimbursement> retrieveAllReimbursement();
	List<Reimbursement> retrieveUserReimbursement(int id);
	List<Reimbursement> retrieveSubmittedReimbursement();
	List<Reimbursement> retrieveApprovedReimbursement();
	List<Reimbursement> retrieveRejectedReimbursement();
	
}
