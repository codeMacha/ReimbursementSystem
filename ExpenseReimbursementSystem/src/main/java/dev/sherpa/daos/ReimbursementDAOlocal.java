package dev.sherpa.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.sherpa.entities.Reimbursement;

public class ReimbursementDAOlocal implements ReimbursementDAO{

	private static Map<Integer, Reimbursement> reimbursement_table = new HashMap<Integer, Reimbursement>();
	private int idGenerator = 1;
	
	@Override
	public Reimbursement createReimbursement(Reimbursement reimbursement) {
		reimbursement.setrId(idGenerator);
		idGenerator++;
		reimbursement_table.put(reimbursement.getrId(), reimbursement);
		return reimbursement;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		
		return reimbursement_table.get(id);
	}

	@Override
	public List<Reimbursement> getAllReimbursement() {
		List<Reimbursement> rlist = new ArrayList<Reimbursement>(reimbursement_table.values());
		return rlist;
	}

	@Override
	public List<Reimbursement> getAllReimbursementbyStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return false;
	}

}
