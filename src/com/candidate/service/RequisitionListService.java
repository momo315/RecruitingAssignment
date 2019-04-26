package com.candidate.service;

import java.util.List;

import com.candidate.dao.RequisitionListDao;
import com.internal.model.requisitionData;

public class RequisitionListService {

	public List<requisitionData> getReqList(String term){
		RequisitionListDao requisitionListDao = new RequisitionListDao();
		List<requisitionData> reqList = requisitionListDao.getReqList(term);
		return reqList;
	}
}
