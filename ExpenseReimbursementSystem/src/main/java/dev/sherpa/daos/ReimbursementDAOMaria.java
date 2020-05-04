package dev.sherpa.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.sherpa.entities.Reimbursement;
import dev.sherpa.utils.ConnectionUtil;

public class ReimbursementDAOMaria implements ReimbursementDAO {

	@Override
	public Reimbursement createReimbursement(Reimbursement reimbursement) {
		String sql = "INSERT INTO Reimbursementdb.REIMBURSEMENT VALUES (?,?,?,?,?)";
		
		try(Connection conn = ConnectionUtil.createConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, 0);
			ps.setString(2, reimbursement.getDescription());
			ps.setInt(3, reimbursement.getAmount());
			ps.setInt(4, reimbursement.getRequesterId());
			ps.setString(5, reimbursement.getStatus());
			ps.execute(); // execute the insert statement
			
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int key = rs.getInt("REIMBURSEMENT_ID");
			reimbursement.setrId(key);			
			return reimbursement;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		String sql = "SELECT * FROM Reimbursementdb.REIMBURSEMENT WHERE REIMBURSEMENT_ID = ?";
		try(Connection conn = ConnectionUtil.createConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Reimbursement reimbursement = new Reimbursement();
			reimbursement.setrId(rs.getInt("REIMBURSEMENT_ID"));
			reimbursement.setDescription(rs.getString("DESCRIPTION"));
			reimbursement.setAmount(rs.getInt("AMOUNT"));
			reimbursement.setRequesterId(rs.getInt("EMPLOYEE_ID"));
			reimbursement.setStatus(rs.getString("STATUS"));
			
			return reimbursement;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Reimbursement> getAllReimbursement() {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Reimbursementdb.REIMBURSEMENT";
			List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) {
				Reimbursement t = new Reimbursement();
				t.setrId(rs.getInt("REIMBURSEMENT_ID"));
				t.setDescription(rs.getString("DESCRIPTION"));
				t.setAmount(rs.getInt("AMOUNT"));
				t.setRequesterId(rs.getInt("EMPLOYEE_ID"));
				t.setStatus(rs.getString("STATUS"));
				reimbursementList.add(t);
			}
			return reimbursementList;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Reimbursement> getAllReimbursementbyStatus(String status) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Reimbursementdb.REIMBURSEMENT WHERE STATUS = ? AND EMPLOYEE_ID = ?";
			List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status);
	
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) {
				Reimbursement t = new Reimbursement();
				t.setrId(rs.getInt("REIMBURSEMENT_ID"));
				t.setDescription(rs.getString("DESCRIPTION"));
				t.setAmount(rs.getInt("AMOUNT"));
				t.setRequesterId(rs.getInt("EMPLOYEE_ID"));
				t.setStatus(rs.getString("STATUS"));
				reimbursementList.add(t);
			}
			return reimbursementList;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void updateReimbursement(Reimbursement reimbursement) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "UPDATE Reimbursementdb.REIMBURSEMENT SET DESCRIPTION = ?, AMOUNT = ?, EMPLOYEE_ID = ?, STATUS = ? WHERE REIMBURSEMENT_ID = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setString(1, reimbursement.getDescription());
			ps.setInt(2, reimbursement.getAmount());
			ps.setInt(3, reimbursement.getRequesterId());
			ps.setString(4, reimbursement.getStatus());
			ps.setInt(5, reimbursement.getrId());
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public boolean removeReimbursement(Reimbursement reimbursement) {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = " DELETE FROM Reimbursementdb.REIMBURSEMENT WHERE REIMBURSEMENT_ID = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setInt(1, reimbursement.getrId());
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public List<Reimbursement> getReimbursementbyemployeeId(int id) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM Reimbursementdb.REIMBURSEMENT WHERE EMPLOYEE_ID = ? ";
			List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) {
				Reimbursement t = new Reimbursement();
				t.setrId(rs.getInt("REIMBURSEMENT_ID"));
				t.setDescription(rs.getString("DESCRIPTION"));
				t.setAmount(rs.getInt("AMOUNT"));
				t.setRequesterId(rs.getInt("EMPLOYEE_ID"));
				t.setStatus(rs.getString("STATUS"));
				reimbursementList.add(t);
			}
			return reimbursementList;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
