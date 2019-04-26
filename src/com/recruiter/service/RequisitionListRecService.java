package com.recruiter.service;

import java.util.List;

import com.candidate.dao.RequisitionListDao;
import com.internal.model.requisitionData;
import com.recruiter.dao.RequisitionListRecDao;

public class RequisitionListRecService {
	
	public List<requisitionData> getReqList(String empId){
		RequisitionListRecDao requisitionListRecDao = new RequisitionListRecDao();
		List<requisitionData> reqList = requisitionListRecDao.getReqList(empId);
		return reqList;
	}

}
