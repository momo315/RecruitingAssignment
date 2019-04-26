package com.recruiter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internal.model.requisitionData;
import com.internal.util.ConnectionManager;

public class RequisitionListRecDao {
	
	public List<requisitionData> getReqList(String empId) {
		String sql;
		sql = "	select req_id,req_name,status,location,experience from reqs where createdby like ? ";
		List<requisitionData> upList = new ArrayList<requisitionData>();
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				requisitionData rd = new requisitionData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				upList.add(rd);
			}
			return upList;
			
		}catch(SQLException e) {
			System.out.println("reqlistdao : "+e.getMessage());
			return upList;
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
