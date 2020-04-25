package dev.sherpa.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.sherpa.entities.Employee;
import dev.sherpa.utils.ConnectionUtil;

public class EmployeeDAOMaria implements EmployeeDAO {

	@Override
	public Employee createEmployee(Employee employee) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "INSERT INTO Reimbursementdb.EMPLOYEE VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, 0);
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getUsername());
			ps.setString(4, employee.getPassword());
			ps.setInt(5, employee.getManagerId());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();// gets first record
			
			int key = rs.getInt("employee_ID");
			employee.seteId(key);
			return employee;		
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Employee getEmployeeById(int id) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Reimbursementdb.EMPLOYEE WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			// result set contains our information
			// by default result points to before the first record returned
			ResultSet rs = ps.executeQuery();
			
			// moves cursor one spot to first record
			rs.next();
			
			Employee employee = new Employee();
			
			employee.seteId(rs.getInt("EMPLOYEE_ID"));
			employee.setName(rs.getString("NAME"));
			employee.setUsername(rs.getString("USERNAME"));
			employee.setPassword(rs.getString("PASSWORD"));
			employee.setManagerId(rs.getInt("MANAGER_ID"));
			
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Reimbursementdb.EMPLOYEE";
			List<Employee> employee_list = new ArrayList<Employee>();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) {
				Employee t = new Employee();
				t.seteId(rs.getInt("EMPLOYEE_ID"));
				t.setName(rs.getString("NAME"));
				t.setUsername(rs.getString("USERNAME"));
				t.setPassword(rs.getString("USERNAME"));
				t.setManagerId(rs.getInt("MANAGER_ID"));
				employee_list.add(t);
			}
			return employee_list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "UPDATE Reimbursementdb.EMPLOYEE SET NAME = ?, USERNAME = ?, PASSWORD = ?, MANAGER_ID = ? WHERE EMPLOYEE_ID = ?";
			// when you first save an object it has an id of 0
			// please return the primary key of the object we just saved
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getUsername());
			ps.setString(3, employee.getPassword());
			ps.setInt(4, employee.getManagerId());
			ps.setInt(5, employee.geteId());
			ps.execute(); // execute the update statement
			
			return employee;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean removeEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getEmployeeByuandpname(String uname, String pword) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Reimbursementdb.EMPLOYEE WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pword);
			
			// result set contains our information
			// by default result points to before the first record returned
			ResultSet rs = ps.executeQuery();
			
			// moves cursor one spot to first record
			rs.next();
			
			Employee employee = new Employee();
			
			employee.seteId(rs.getInt("EMPLOYEE_ID"));
			employee.setName(rs.getString("NAME"));
			employee.setUsername(rs.getString("USERNAME"));
			employee.setPassword(rs.getString("PASSWORD"));
			employee.setManagerId(rs.getInt("MANAGER_ID"));
			
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean checkUsernamePassword(String uname, String pword) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Reimbursementdb.EMPLOYEE WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pword);
			
			// result set contains our information
			// by default result points to before the first record returned
			ResultSet rs = ps.executeQuery();
			
			// moves cursor one spot to first record
			if(rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	



}
