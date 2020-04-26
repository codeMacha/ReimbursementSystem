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
		List<Reimbursement> rlist =  getAllReimbursement();
		List<Reimbursement> statuslist = new ArrayList<Reimbursement>();
		for(int i = 0; i < rlist.size(); i++) {
			if (rlist.get(i).getStatus() == status) {
				statuslist.add(rlist.get(i));
			}
		}
		return statuslist;	
	}

	@Override
	public void updateReimbursement(Reimbursement reimbursement) {
		reimbursement_table.put(reimbursement.getrId(), reimbursement);
	}

	@Override
	public boolean removeReimbursement(Reimbursement reimbursement) {
		reimbursement_table.remove(reimbursement.getrId());
		return true;
	}

	@Override
	public List<Reimbursement> getReimbursementbyemployeeId(int id) {
		List<Reimbursement> rlist =  getAllReimbursement();
		List<Reimbursement> nlist = new ArrayList<Reimbursement>();
		for(int i = 0; i < rlist.size(); i++) {
			if (rlist.get(i).getRequesterId()== id) {
				nlist.add(rlist.get(i));
			}
		}
		return nlist;	
	}

	

}
