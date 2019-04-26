package com.candidate.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.internal.model.user;
import com.internal.util.ConnectionManager;

public class RegistrationDao {
		
	public String register(user usr) {
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getCon();
		PreparedStatement pstmt= null;
		ResultSet rs =null;
		try {    
		pstmt = con.prepareStatement("select ID from users where ID = ?");
		pstmt.setString(1,usr.getEmpid());
		rs = pstmt.executeQuery();
		if(rs.next()) {
			System.out.println("RegistrationDAO : user Exists");
			return "userexist";
		}
		else {
			pstmt = con.prepareStatement("insert into users(email,password,id,type,resume,firstname,lastname,gender) values(?,?,?,?,?,?,?,? )");
			pstmt.setString(1, usr.getUsername());
			pstmt.setString(2,usr.getPassword());
			pstmt.setString(3, usr.getEmpid().toUpperCase());
			pstmt.setString(4, "CAN");
			pstmt.setBinaryStream(5, usr.getPdf(),usr.getPdf().available());
			pstmt.setString(6, usr.getFname());
			pstmt.setString(7, usr.getLname());
			pstmt.setString(8, usr.getGender());
			int i = pstmt.executeUpdate();
			System.out.println("RegistrationDAO : " +i);
			return "success";
		}
		}catch(SQLException|IOException e) {
			System.out.println(e.getMessage()+"error");
			return "exception";
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
