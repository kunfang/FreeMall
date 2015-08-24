package com.ftc.foundation.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("defaultDao")
public class DefaultDAO extends AbstractDAOBase{
 
	@Override
	public String populatePageHQL(Object object, String orderByFields,
			String orderType) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doUpdate(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object toUpdate(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List doPageList(String statementID, Object parameterObject,
			int firstResult, int rowsPerPage, String orderByFields,
			String orderType) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
