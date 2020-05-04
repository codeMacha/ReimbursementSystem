package dev.sherpa.daotests;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.sherpa.daos.ManagerDAO;
import dev.sherpa.daos.ManagerDAOMaria;
import dev.sherpa.entities.Manager;

public class ManagerDAOmariatest {

	private static ManagerDAO mdao = new ManagerDAOMaria();
	
	@Test
	public void createManager() {
		Manager manager = new Manager();
		manager.setUsername("dille");
		manager.setPassword("working");
		mdao.createManager(manager);
		
		System.out.println(manager);
	}
	
	@Test
	public void getManager() {
		System.out.println(mdao.getManagerbyId(2));
	}
	
	@Test
	public void updateManager() {
		Manager manager = mdao.getManagerbyId(2);
		manager.setUsername("zero");
		mdao.updateManager(manager);
		System.out.println(manager);
	}

}
