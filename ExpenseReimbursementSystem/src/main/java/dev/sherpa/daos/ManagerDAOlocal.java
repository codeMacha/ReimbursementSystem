package dev.sherpa.daos;

import java.util.HashMap;
import java.util.Map;

import dev.sherpa.entities.Manager;

public class ManagerDAOlocal implements ManagerDAO{
	
	private static Map<Integer,Manager> manager_table = new HashMap<Integer,Manager>();
	private int idGenerator = 1;

	@Override
	public Manager createManager(Manager manager) {
		manager.setmId(idGenerator);
		idGenerator++;
		
		manager_table.put(manager.getmId(), manager);
		return manager;
	}

	@Override
	public Manager getManagerbyId(int id) {
		return manager_table.get(id);
	}

	@Override
	public Manager updateManager(Manager manager) {
		manager_table.put(manager.getmId(), manager);
		return manager;
	}

	@Override
	public boolean removeManager(Manager manager) {
		manager_table.remove(manager.getmId());
		return false;
	}

	@Override
	public boolean getManagerbyUp(String uname, String pword) {
		return true;
	}

}
