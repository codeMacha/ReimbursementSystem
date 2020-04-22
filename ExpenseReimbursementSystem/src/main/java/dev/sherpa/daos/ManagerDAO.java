package dev.sherpa.daos;

import dev.sherpa.entities.Manager;

public interface ManagerDAO {
	
	// create
	Manager createManager(Manager manager);
	
	// read
	Manager getManagerbyId(int id);
	
	// update
	Manager updateManager(Manager manager);
	
	//delete
	boolean removeManager(Manager manager);
	
}
