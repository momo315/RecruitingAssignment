package com.candidate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internal.model.requisitionData;
import com.internal.util.ConnectionManager;

public class RequisitionViewDao {
	
	public requisitionData getReq(int id) {
		String sql = "select * from reqs where req_id = ?";
		requisitionData rd = null;
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rd = new requisitionData(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(9), rs.getString(8));
			}
			return rd;
		}catch(SQLException e) {
			System.out.println("RequisistionViewDao : "+e.getMessage());
			return rd;
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
