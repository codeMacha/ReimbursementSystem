package dev.sherpa.services;

import java.util.List;

import dev.sherpa.daos.ReimbursementDAO;
import dev.sherpa.daos.ReimbursementDAOMaria;
import dev.sherpa.entities.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService{

	private ReimbursementDAO rdao = new ReimbursementDAOMaria();

	@Override
	public Reimbursement createReimbursement(Reimbursement reimbursement) {
		rdao.createReimbursement(reimbursement);
		return reimbursement;
	}

	@Override
	public void updateReimbursement(Reimbursement reimbursement) {
		rdao.updateReimbursement(reimbursement);
	}

	@Override
	public Reimbursement getReimbursemnetById(int id) {
		return rdao.getReimbursementById(id);
	}

	@Override
	public List<Reimbursement> retrieveAllReimbursement() {
		return rdao.getAllReimbursement();
	}

	@Override
	public List<Reimbursement> retrieveSubmittedReimbursement() {
		return rdao.getAllReimbursementbyStatus("Submitted");
	}

	@Override
	public List<Reimbursement> retrieveApprovedReimbursement() {
		return rdao.getAllReimbursementbyStatus("Approved");
	}

	@Override
	public List<Reimbursement> retrieveRejectedReimbursement() {
		return rdao.getAllReimbursementbyStatus("Rejected");
	}

	@Override
	public List<Reimbursement> retrieveUserReimbursement(int id) {
		return rdao.getReimbursementbyemployeeId(id);
	}
	
}
