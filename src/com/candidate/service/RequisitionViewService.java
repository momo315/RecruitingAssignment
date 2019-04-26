package com.candidate.service;

import com.candidate.dao.RequisitionViewDao;
import com.internal.model.requisitionData;

public class RequisitionViewService {
	
	public requisitionData getReq(int id) {
		RequisitionViewDao requisitionViewDao = new RequisitionViewDao();
		requisitionData rd = requisitionViewDao.getReq(id);
		return rd;
	}

}
