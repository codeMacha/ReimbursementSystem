package dev.sherpa.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.sherpa.entities.Manager;
import dev.sherpa.utils.ConnectionUtil;

public class ManagerDAOMaria implements ManagerDAO{

	@Override
	public Manager createManager(Manager manager) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "INSERT INTO Reimbursementdb.MANAGER VALUES (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, 0);
			ps.setString(2, manager.getUsername());
			ps.setString(3, manager.getPassword());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();// gets first record
			
			int key = rs.getInt("manager_ID");
			manager.setmId(key);
			return manager;		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Manager getManagerbyId(int id) {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Reimbursementdb.MANAGER WHERE MANAGER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			// result set contains our information
			// by default result points to before the first record returned
			ResultSet rs = ps.executeQuery();
			
			// moves cursor one spot to first record
			rs.next();
			
			Manager manager = new Manager();
			
			manager.setmId(rs.getInt("MANAGER_ID"));
			manager.setUsername(rs.getString("USERNAME"));
			manager.setPassword(rs.getString("PASSWORD"));
			
			return manager;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Manager updateManager(Manager manager) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "UPDATE Reimbursementdb.MANAGER SET USERNAME = ?, PASSWORD = ? WHERE MANAGER_ID = ?";
			// when you first save an object it has an id of 0
			// please return the primary key of the object we just saved
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, manager.getUsername());
			ps.setString(2, manager.getPassword());
			ps.setInt(3, manager.getmId());
			ps.execute(); // execute the update statement
			
			return manager;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean removeManager(Manager manager) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "DELETE FROM Reimbursementdb.MANAGER WHERE MANAGER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, manager.getmId());
			ps.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
