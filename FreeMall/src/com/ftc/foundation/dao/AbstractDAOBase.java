package com.ftc.foundation.dao;

import java.util.List;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) </p>
 * <p>Company: </p>
 * @author
 * @version 1.0
 */
public abstract class AbstractDAOBase implements DAOBase{
	
	private IbatisSqlMapTemplate ibatisSqlMapTemplate = new IbatisSqlMapTemplate();
	private int num = 10;
		  
		  public AbstractDAOBase() {
		  }
		  
			/**
			 * 目的：获取分页记录数
			 */
			@Override
			public int doTotalPageCount(String statementID, Object obj) throws Exception {
				Object object = null;
				try {
					object = this.getIbatisSqlMapTemplate().queryForObject(statementID,obj);
				}
				catch (Exception ex) {
					ex.printStackTrace();
					throw ex;
				}
				if (object == null)
				return 0;
				return ( (Integer) object).intValue();
			}
		
		  public int toListCount(String statementID, Object obj, String sql) throws Exception {
				Object object = null;
				
				try {
					object = this.getIbatisSqlMapTemplate().queryForObject(statementID, sql);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				if (object == null) //
					return 0;
				return ( (Integer) object).intValue();
			}
			
			
		 
		  @Override
		public List toList( String statementID, Object object) throws
		      Exception {
			  List list = this.getIbatisSqlMapTemplate().queryForList(statementID, object);
			  return list;
		  }
		
		  /**
		   * @param currentPage
		   * @param rowsPerPage
		   * @param orderByFields
		   * @param orderType 
		   * @return ArrayList 
		   * @throws GeneralException
		   */
		  private List toListInDAO(String statementID, Object parameterObject,
		     int firstResult, int rowsPerPage,
		     String orderByFields, String orderType) throws
		      Exception {
		//		orderByFields = new StringUtil().nullOrEmptyToValue(orderByFields, "1");
		    List list = null;
		    try {
		      list = getIbatisSqlMapTemplate().queryForList(statementID, parameterObject,
		          firstResult, rowsPerPage);
		    }
		    catch (Exception ex) {
		      ex.printStackTrace();
		    }
		    return list;
		  }
		  /**
		   * 插入数据
		   * @param vo
		   * @throws GeneralException
		   */
		  @Override
		public void doInsert(String statementID, Object obj) throws Exception {
		    try {
		      this.getIbatisSqlMapTemplate().insert(statementID, obj);
		      
		    }
		    catch (Exception ex) {
		      ex.printStackTrace();
		      throw ex;
		    }
		  }
		  
		  /**
		   * 插入数据
		   * @param vo
		   * @throws GeneralException
		   */
		  @Override
		public Object doInsertResult(String statementID, Object obj) throws Exception {
			  Object objResult = null;
			  try {
				  objResult = this.getIbatisSqlMapTemplate().insert(statementID, obj);
				  
			  }
			  catch (Exception ex) {
				  ex.printStackTrace();
				  throw ex;
			  }
			  return objResult;
		  }
		
		  /**
		   *
		   * @param statementID
		   * @param vo
		   * @throws java.lang.Exception
		   */
		  @Override
		public int doDelete(String statementID, String[] pks) throws Exception {
		    int count = 0;
		    try {
		      count = this.getIbatisSqlMapTemplate().deleteAll(statementID, pks);
		    }
		    catch (Exception ex) {
		      ex.printStackTrace();
		      throw ex;
		    }
		    return count;
		  }
		  
		  @Override
		public int doDelete(String statementID, String pk) throws Exception {
			    int count = 0;
			    try {
			      count = this.getIbatisSqlMapTemplate().delete(statementID, pk);
			    }
			    catch (Exception ex) {
			      ex.printStackTrace();
			      throw ex;
			    }
			    return count;
			  }
		  
		  @Override
		public int doDelete(String statementID, Object obj) throws Exception {
			    int count = 0;
			    try {
			      count = this.getIbatisSqlMapTemplate().delete(statementID, obj);
			    }
			    catch (Exception ex) {
			      ex.printStackTrace();
			      throw ex;
			    }
			    return count;
			  }
		
		  @Override
		public Object toUpdate(String statementID, Object obj) throws Exception {
		    Object object = null;
		    try {
		      object = this.getIbatisSqlMapTemplate().queryForObject(statementID,
		          obj);
		    }
		    catch (Exception ex) {
		      ex.printStackTrace();
		    }
		    return object;
		  }
		
		  @Override
		public int doUpdate(String statementID, Object obj) throws Exception {
		    int count = 0;
		    try {
		      count = this.getIbatisSqlMapTemplate().update(statementID, obj);
		    }
		    catch (Exception ex) {
		      ex.printStackTrace();
		      throw ex;
		    }
		    return count;
		  }
		
		  @Override
		public Object toView(String statementID, Object object) throws Exception {
		    Object object2 = null;
		    try {
		      object2 = this.getIbatisSqlMapTemplate().queryForObject(statementID,
		          object);
		    }
		    catch (Exception ex) {
		      ex.printStackTrace();
		    }
		    return object2;
		  }
		
		  @Override
		public int getTotalPageCount(String statementID, Object obj) throws
		      Exception {
		    Object object = null;
		    try {
		      object = this.getIbatisSqlMapTemplate().queryForObject(statementID,
		          obj);
		    }
		    catch (Exception ex) {
		      ex.printStackTrace();
		    }
		    if (object == null) 
		      return 0;
		    return ( (Integer) object).intValue();
		  }
		
		  /**
		   * 
		   * @return IbatisSqlMapTemplate
		   */
		  @Override
		public IbatisSqlMapTemplate getIbatisSqlMapTemplate() {
		    return ibatisSqlMapTemplate;
		  }
		  
		  	/**
		  	  * �?��事务
			  * @throws Exception
			  */
			 @Override
			public void startTransaction() throws Exception {
				 ibatisSqlMapTemplate.startTransaction();
			 }
		
			 /**
			  * 提交事务
			  * @throws Exception
			  */
			 @Override
			public void commitTransation() throws Exception {
				 ibatisSqlMapTemplate.commitTransation();
			 }
		
			 /**
			  * 关闭事务
			  * @throws Exception
			  */
			 @Override
			public void endTransaction() throws Exception {
				 ibatisSqlMapTemplate.endTransaction();
			 }
			 
			 public String populatePageHQL(Object object) throws Exception {
					String result = populatePageHQL(object, "1", "");
					return result;
				}
				
			 public abstract String populatePageHQL(Object object, String orderByFields,
						String orderType) throws Exception;
			 
			 public static void main(String[] args) {
		//			String [] aa=new String[4];
				}
}



