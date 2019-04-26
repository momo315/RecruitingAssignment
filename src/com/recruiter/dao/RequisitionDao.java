package com.recruiter.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internal.model.requisitionData;
import com.internal.util.ConnectionManager;

import oracle.jdbc.driver.OracleTypes;

public class RequisitionDao {
	
	public int createReq(requisitionData rd) {
		String sql = "BEGIN insert into reqs (req_name,created_at,expiry,status,location,experience,createdby,skills) values(?,?,?,?,?,?,?,?) returning req_id into ? ; END ;";
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getCon();
		CallableStatement pstmt= null;
		int id = -1;
		try {
		pstmt = con.prepareCall(sql);
		pstmt.setString(1, rd.getReqName());
		pstmt.setDate(2, rd.getCreatedAt());
		pstmt.setDate(3, rd.getExpiry());
		pstmt.setString(4, rd.getStatus());
		pstmt.setString(5, rd.getLocation());
		pstmt.setInt(6, rd.getExperience());
		pstmt.setString(7, rd.getCreatedBy());
		pstmt.setString(8, rd.getSkills());
		pstmt.registerOutParameter(9, OracleTypes.NUMBER);
		pstmt.executeQuery();
		id = pstmt.getInt(9);
		return id;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return id;
		}finally {
			
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
