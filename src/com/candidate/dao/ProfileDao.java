package com.candidate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internal.model.userProfile;
import com.internal.util.ConnectionManager;

public class ProfileDao {
	
	public userProfile getUser(int usr) {
		userProfile up;
		up=null;
		String sql = "select email,id,gender,firstname,lastname,address,phno,bio from users where sid = ?  ";
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getCon();
		PreparedStatement pstmt= null;
		ResultSet rs =null;
		try {
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, usr);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				up = new userProfile(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			}
			return up;
		}catch(SQLException e) {
			System.out.println("getUser : "+e.getMessage());
			return up;
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
