package com.ftc.foundation.dao;

import java.util.List;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author
 * @version 1.0
 */

public interface DAOBase {
	public List toList( String statementID, Object object) throws Exception;
	public Object toView(String statementID, Object object) throws Exception; //查询
	
	public void doInsert(String statementID, Object obj) throws Exception; //新增
	public Object doInsertResult(String statementID, Object obj) throws Exception; //新增
	
	public int doDelete(String statementID, String[] pks) throws Exception; //批量删除
	public int doDelete(String statementID, String pk) throws Exception; //主键删除
	public int doDelete(String statementID,Object object) throws Exception;
	
	public Object toUpdate(Object obj) throws Exception; //修改
	public Object toUpdate(String statementID, Object obj) throws Exception; //修改
	
	public int doUpdate(Object obj) throws Exception; //修改
	public int doUpdate(String statementID, Object obj) throws Exception; //修改
	
	public int getTotalPageCount(String statementID, Object obj) throws Exception; //分页
	public IbatisSqlMapTemplate getIbatisSqlMapTemplate();
	public void startTransaction() throws Exception; //开始事务
	public void commitTransation() throws Exception;  //提交终止事务
	public void endTransaction() throws Exception;  //中止事务
	
	public List doPageList(String statementID, Object parameterObject,int firstResult, int rowsPerPage,String orderByFields, String orderType) throws Exception;
	public int doTotalPageCount(String statementID, Object obj) throws Exception;
}
 
