package com.candidate.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internal.util.ConnectionManager;

public class ResumeDao {
	
	public InputStream getRes(int user) {
		System.out.println("resumedao : user = "+user);
		String sql = "select resume from users where sid = ? ";
		ConnectionManager cm = new ConnectionManager();
		InputStream pdf = null;
		Connection con = cm.getCon();
		PreparedStatement pstmt= null;
		ResultSet rs =null;
		try {
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			pdf=rs.getBinaryStream(1);
			
		}
		return pdf;
		}catch(Exception e) {
			System.out.println("resumedao  :" +e.getMessage());
			return pdf;
		}finally{
//			try {
//				if(rs != null) {
//					rs.close();
//				}
//				}catch(SQLException e) {
//					System.out.println("failed to close : "+e.getMessage());
//				}
//				try {
//					if(pstmt != null) {
//						pstmt.close();
//					}
//					}catch(SQLException e) {
//						System.out.println("failed to close : "+e.getMessage());
//					}
//					cm.shutDown();
		}
		
	}

}
