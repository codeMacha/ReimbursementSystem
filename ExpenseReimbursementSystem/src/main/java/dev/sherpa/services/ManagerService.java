package dev.sherpa.services;

import dev.sherpa.entities.Manager;

public interface ManagerService {

	public Manager getManagerbyId(int id);
	
	public boolean getManagerbyUandP(String uname, String pword);
	
}
