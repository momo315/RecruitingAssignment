package com.candidate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internal.model.requisitionData;
import com.internal.model.userProfile;
import com.internal.util.ConnectionManager;

public class RequisitionListDao {

	public List<requisitionData> getReqList(String term) {
		String sql;
		if(term == null || term == "") {
			sql = "	select req_id,req_name,status,location,experience from reqs ";
		}else {
			sql = "	select req_id,req_name,status,location,experience from reqs where upper(req_name) like upper(?) or upper(location) like upper(?) or upper(skills) like upper(?)";
		}
		term="%"+term+"%";
		List<requisitionData> upList = new ArrayList<requisitionData>();
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			if(!term.equals("%%")) {
			pstmt.setString(1, term);
			pstmt.setString(2, term);
			pstmt.setString(3, term);
			}
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
