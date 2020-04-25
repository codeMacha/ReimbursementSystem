package dev.sherpa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	public static Connection createConnection() {
		
		try {
			//create a properties object to store information
			Properties props = new Properties();
			
			Class.forName("org.mariadb.jdbc.Driver");

			
			// use file io to read in a file
			FileInputStream in = new FileInputStream(ConnectionUtil.class.getClassLoader().getResource("connection.properties").getFile());
			// populate the properties object by loading in the fileinputstream 
			props.load(in);
			
			String details = props.getProperty("condetails");
			
			Connection conn = DriverManager.getConnection(details);
			return conn;
		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}

