package com.internal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {
	


	Connection con;
	
	public Connection getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");   
			this.con=DriverManager.getConnection(  "jdbc:oracle:thin:@localhost:1521:xe","system","amenhotep");
			}catch(LinkageError|ClassNotFoundException|SQLException e) {
				System.out.println("getCon error : "+e.getMessage());
			}
		return con;
	}

	
	public void shutDown() {
		try{
			con.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage() + "at con manager");
		}
	}

}
