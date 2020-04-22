package dev.sherpa.daotests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dev.sherpa.daos.ManagerDAO;
import dev.sherpa.daos.ManagerDAOlocal;
import dev.sherpa.entities.Manager;

public class ManagerDAOtest {

	private ManagerDAO mdao = new ManagerDAOlocal();

	 @Before 
	 public void setup(){ 
		 Manager manager = new Manager();
		 manager.setUsername("immanager"); 
		 manager.setPassword("mypassword");
		 mdao.createManager(manager);
	}
	 
	 @Test
	 public void getallManager() {
		Manager mlist = mdao.getManagerbyId(1);
		System.out.println(mlist);
	}	 
	
	@Test
	public void create() {
		Manager manager = new Manager();
		manager.setUsername("kakakaka");
		manager.setPassword("kukuku");
		mdao.createManager(manager);
	}

}
