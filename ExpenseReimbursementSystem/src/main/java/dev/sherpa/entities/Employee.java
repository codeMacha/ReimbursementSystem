package dev.sherpa.entities;

public class Employee {

	private int eId;
	private String name;
	private String username;
	private String password;
	private int managerId;
	
	public Employee() {
		super();
	}

	public Employee(int eId, String username, String password) {
		super();
		this.eId = eId;
		this.username = username;
		this.password = password;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int id) {
		this.managerId = id;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", name=" + name + ", username=" + username + ", password=" + password + ", managerId="+ managerId + "]";
	}

}
