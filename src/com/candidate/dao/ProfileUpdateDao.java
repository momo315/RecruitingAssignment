package com.candidate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.internal.util.ConnectionManager;

public class ProfileUpdateDao {
	
	public int updateProfile(int id,String address,String phno,String bio) {
		int result;
		String sql = "update users set address = ? ,phno = ? , bio = ? where sid = ?";
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getCon();
		PreparedStatement pstmt = null;
		try {
		pstmt = con.prepareStatement(sql);
		if(address != null && !address.equals("")) {
			pstmt.setString(1, address);
		}
		else {
			pstmt.setNull(1, Types.VARCHAR);
		}
		if(phno != null && !phno.equals("")) {
			pstmt.setString(2, phno);
		}
		else {
			pstmt.setNull(2, Types.VARCHAR);
		}
		if(bio != null && !bio.equals("")) {
			pstmt.setString(3, bio);
		}
		else {
			pstmt.setNull(3, Types.VARCHAR);
		}
		pstmt.setInt(4, id);
		result = pstmt.executeUpdate();
		return result;
		}catch(SQLException e) {
			System.out.println("Profile update dao : "+e.getMessage());
			return -1;
		}finally {
			
				try {
					if(pstmt != null) {
						pstmt.close();
					}
					}catch(SQLException e) {
						System.out.println("failed to close pstmt : "+e.getMessage());
					}
					cm.shutDown();
		}
	}

}
