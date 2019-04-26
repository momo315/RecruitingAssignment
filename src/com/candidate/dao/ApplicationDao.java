package com.candidate.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import com.internal.util.ConnectionManager;

import oracle.jdbc.driver.OracleTypes;

public class ApplicationDao {
	
	public int createApplication(int reqid,int userid,Date createdat) {
		int f=-1;
		String sql = "BEGIN insert into applications(REQID , USERID , APPLIED_AT) values (?,?,?) returning APPID into ? ; END;";
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getCon();
		CallableStatement cstmt = null;
		try {
			cstmt = con.prepareCall(sql);
			cstmt.setInt(1, reqid);
			cstmt.setInt(2, userid);
			cstmt.setDate(3, createdat);
			cstmt.registerOutParameter(4, OracleTypes.NUMBER);
			cstmt.executeQuery();
			f = cstmt.getInt(4);
			return f;
		}catch(SQLException e) {
			System.out.println("ApplicationDao : "+e.getMessage());
			return f;
		}finally {
			try {
				if(cstmt != null) {
					cstmt.close();
				}
				}catch(SQLException e) {
					System.out.println("failed to close : "+e.getMessage());
				}
		cm.shutDown();
		}
	}

}
