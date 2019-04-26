package com.recruiter.service;

import com.internal.model.requisitionData;
import com.recruiter.dao.RequisitionDao;

public class RequisitionService {
	
	public int createReq(requisitionData rd) {
		RequisitionDao requisitionDao = new RequisitionDao();
		int id = requisitionDao.createReq(rd);
		System.out.println("reqserv id = "+id);
		return id;
	}

}
