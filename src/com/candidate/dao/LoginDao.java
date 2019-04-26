package com.candidate.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internal.model.userProfile;
import com.internal.util.ConnectionManager;

public class LoginDao {
	
	public userProfile login(String user,String pass) {
		String sql = "select * from users where email = ?";
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getCon();
		PreparedStatement pstmt= null;
		ResultSet rs =null;
		try {       
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user);
		rs = pstmt.executeQuery();
		System.out.println("dao hit");
		if(rs.next()) {
			userProfile up = new userProfile(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(9), rs.getString(5), rs.getString(7), rs.getString(8));
			return up;
		}
		else {
			return new userProfile(-1);
		}

		}catch(Exception e) {
			System.out.println(e.getMessage()+" :error in logindao");
			return new userProfile(-2);
		}finally {
			try {
			if(rs != null) {
				rs.close();
			}
			}catch(SQLException e) {
				System.out.println("failed to close : "+e.getMessage());
			}
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				}catch(SQLException e) {
					System.out.println("failed to close : "+e.getMessage());
				}
				cm.shutDown();
				
		}
	}
}
