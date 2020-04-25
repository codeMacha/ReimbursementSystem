package dev.sherpa.services;

import dev.sherpa.daos.ManagerDAO;
import dev.sherpa.daos.ManagerDAOMaria;
import dev.sherpa.entities.Manager;

public class ManagerServiceImpl implements ManagerService{

	private ManagerDAO mdao = new ManagerDAOMaria();
	
	@Override
	public Manager getManagerbyId(int id) {
		return mdao.getManagerbyId(id);
	}

	@Override
	public boolean getManagerbyUandP(String uname, String pword) {
		return mdao.getManagerbyUp(uname, pword);
	}

	
}
