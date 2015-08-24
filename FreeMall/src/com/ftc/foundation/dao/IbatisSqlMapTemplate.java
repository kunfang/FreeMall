package com.ftc.foundation.dao;

import java.io.*;
import java.util.*;
import java.sql.Connection;

import com.alltrust.crypto.CryptoUtil;
import com.ibatis.common.resources.*;
import com.ibatis.sqlmap.client.*;
import com.ibatis.sqlmap.client.event.*;

/**
 * <p>Title: ibatis模板�?/p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author
 * @version 1.0
 */

public class IbatisSqlMapTemplate {
  private String resource;
  private static SqlMapClient sqlMapClient = null;
  private boolean isStart = false;
  public IbatisSqlMapTemplate() {
    resource = "SqlMapConfig.xml";
  }

  public IbatisSqlMapTemplate(String resource) {
    this.resource = resource;
  }

  /**
   * 开始�事务;
   * @throws Exception
   */
  public void startTransaction() throws Exception {
    sqlMapClient = this.getSqlMapClient();
    sqlMapClient.startTransaction();
    isStart = true;
  }

  /**
   * 提交终止事务;
   * @throws Exception
   */
  public void commitTransation() throws Exception {
    try {
      sqlMapClient.commitTransaction();
    }
    finally {
      sqlMapClient.endTransaction();
      isStart = false;
    }
  }

  /**
   * 中止事务
   * @throws Exception
   */
  public void endTransaction() throws Exception {
    try {

    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    finally {
      sqlMapClient.endTransaction();
      isStart = false;
    }
  }

  /**
   *
   * @param statementID
   * @param parameterObject
   * @return
   * @throws java.lang.Exception
   */
  public Object insert(String statementID, Object parameterObject) throws
      Exception {
    if (!isStart) {
      SqlMapClient sqlMapClient = this.getSqlMapClient();
      try {
        sqlMapClient.startTransaction();
        Object obj = sqlMapClient.insert(statementID, parameterObject);
        sqlMapClient.commitTransaction();
        return obj;

      }
      finally {
        sqlMapClient.endTransaction();
      }
    }
    else {
      Object obj = sqlMapClient.insert(statementID, parameterObject);
      return obj;
    }

  }

  /**
   *
   * @param statementID
   * @param object
   * @return
   * @throws java.lang.Exception
   */
  public int update(String statementID, Object parameterObject) throws
      Exception {
    if (!isStart) {
      SqlMapClient sqlMapClient = this.getSqlMapClient();
      try {
        sqlMapClient.startTransaction();
        int count = sqlMapClient.update(statementID, parameterObject);
        sqlMapClient.commitTransaction();
        return count;
      }
      finally {
        sqlMapClient.endTransaction();
      }
    }
    else {
      int count = sqlMapClient.update(statementID, parameterObject);
      return count;

    }
  }

  public int deleteAll(String statementID, String[] pks) throws
      Exception {
    if (!isStart) {
      SqlMapClient sqlMapClient = this.getSqlMapClient();
      try {
        sqlMapClient.startTransaction();
        sqlMapClient.startBatch();
        int count = 0;
        for (int i = 0; i < pks.length; i++) {
          count += sqlMapClient.delete(statementID, pks[i]);
        }
        sqlMapClient.executeBatch();
        sqlMapClient.commitTransaction();
        return count;
      }
      finally {
        sqlMapClient.endTransaction();
      }
    }
    else {
      sqlMapClient.startBatch();
      int count = 0;
      for (int i = 0; i < pks.length; i++) {
        count += sqlMapClient.delete(statementID, pks[i]);
      }
      sqlMapClient.executeBatch();
      return count;

    }
  }

  /**
   *
   * @param statementID
   * @param parameterObject
   * @return
   * @throws java.lang.Exception
   */
  public int delete(String statementID, Object parameterObject) throws
      Exception {
    if (!isStart) {
      SqlMapClient sqlMapClient = this.getSqlMapClient();
      try {
        sqlMapClient.startTransaction();
        int count = sqlMapClient.delete(statementID, parameterObject);
        sqlMapClient.commitTransaction();
        return count;
      }
      finally {
        sqlMapClient.endTransaction();
      }
    }
    else {
      int count = sqlMapClient.delete(statementID, parameterObject);
      return count;

    }
  }

  /**
   *
   * @param statementID
   * @param domain
   * @return
   * @throws java.lang.Exception
   */

  public Object queryForObject(String statementID, Object parameterObject) throws
      Exception {
    if (!isStart) {
      SqlMapClient sqlMapClient = this.getSqlMapClient();
      try {
        sqlMapClient.startTransaction();
        Object obj = sqlMapClient.queryForObject(statementID, parameterObject);
        sqlMapClient.commitTransaction();
        return obj;
      }
      finally {
        sqlMapClient.endTransaction();
      }
    }
    else {
      Object obj = sqlMapClient.queryForObject(statementID, parameterObject);
      return obj;

    }
  }

  /**
   *
   * @param statementID
   * @param domain
   * @param param
   * @return
   * @throws java.lang.Exception
   */

  public Object queryForObject(String statementID, Object parameterObject,
                               Object resultObject) throws Exception {
    if (!isStart) {
      SqlMapClient sqlMapClient = this.getSqlMapClient();
      try {
        sqlMapClient.startTransaction();
        Object obj = sqlMapClient.queryForObject(statementID,
                                                 parameterObject,
                                                 resultObject);
        sqlMapClient.commitTransaction();
        return obj;
      }
      finally {
        sqlMapClient.endTransaction();
      }
    }
    else {
      Object obj = sqlMapClient.queryForObject(statementID,
                                               parameterObject,
                                               resultObject);
      return obj;

    }
  }

  /**
   *
   * @param statementID
   * @param domain
   * @return
   * @throws java.lang.Exception
   */

  public List queryForList(String statementID, Object parameterObject) throws
      Exception {
    if (!isStart) {
      SqlMapClient sqlMapClient = this.getSqlMapClient();
      try {
        sqlMapClient.startTransaction();
        List list = sqlMapClient.queryForList(statementID, parameterObject);
        sqlMapClient.commitTransaction();
        return list;
      }
      finally {
        sqlMapClient.endTransaction();
      }
    }
    else {
      List list = sqlMapClient.queryForList(statementID, parameterObject);
      return list;

    }
  }

  /**
   *
   * @param statementID
   * @param parameterObject
   * @param firstResult
   * @param maxResults
   * @return
   * @throws java.lang.Exception
   */

  public List queryForList(String statementID, Object parameterObject,
                           int firstResult, int maxResults) throws Exception {
    if (!isStart) {
      SqlMapClient sqlMapClient = this.getSqlMapClient();
      try {
        sqlMapClient.startTransaction();
        List list = sqlMapClient.queryForList(statementID,
                                              parameterObject,
                                              firstResult, maxResults);
        sqlMapClient.commitTransaction();
        return list;
      }
      finally {
        sqlMapClient.endTransaction();
      }
    }
    else {
      List list = sqlMapClient.queryForList(statementID,
                                            parameterObject,
                                            firstResult, maxResults);
      return list;

    }
  }

  /**
   *
   * @param statementID
   * @param parameterObject
   * @param rowHandler
   * @return
   * @throws java.lang.Exception
   */

//  public List queryForList(String statementID, Object parameterObject,
//                           RowHandler rowHandler) throws Exception {
//    if (!isStart) {
//      SqlMapClient sqlMapClient = this.getSqlMapClient();
//      try {
//        sqlMapClient.startTransaction();
//        List list = sqlMapClient.queryForList(statementID,
//                                              parameterObject,
//                                              rowHandler);
//        sqlMapClient.commitTransaction();
//        return list;
//      }
//      finally {
//        sqlMapClient.endTransaction();
//      }
//    }
//    else {
//      List list = sqlMapClient.queryForList(statementID,
//                                            parameterObject,
//                                            rowHandler);
//      return list;
//    }
//  }

  /**
   *
   * @param statementID
   * @param parameterObject
   * @param rowHandler
   * @return
   * @throws java.lang.Exception
   */

  public void queryWithRowHandler(String statementID, Object parameterObject,
                                  RowHandler rowHandler) throws Exception {
    if (!isStart) {
      SqlMapClient sqlMapClient = this.getSqlMapClient();
      try {
        sqlMapClient.startTransaction();
        sqlMapClient.queryWithRowHandler(statementID, parameterObject,
                                         rowHandler);
        sqlMapClient.commitTransaction();
      }
      finally {
        sqlMapClient.endTransaction();
      }
    }
    else {
      sqlMapClient.queryWithRowHandler(statementID, parameterObject,
                                       rowHandler);

    }
  }

  /**
   *
   * @param statementID
   * @param parameterObject
   * @param firstResult
   * @param maxResults
   * @return
   * @throws java.lang.Exception
   */

  public List queryForEstarPaginationList(String statementID,
                                           Object parameterObject,
                                           int firstResult, int maxResults) throws
      Exception {
    return queryForList(statementID, parameterObject, firstResult, maxResults);
  }

  /**
   *
   * @param statementID
   * @param parameterObject
   * @param keyProperty
   * @return
   * @throws java.lang.Exception
   */
  public Map queryForMap(String statementID, Object parameterObject,
                         String keyProperty) throws Exception {
    if (!isStart) {
      SqlMapClient sqlMapClient = this.getSqlMapClient();
      try {
        sqlMapClient.startTransaction();
        Map map = sqlMapClient.queryForMap(statementID, parameterObject,
                                           keyProperty);
        sqlMapClient.commitTransaction();
        return map;
      }
      finally {
        sqlMapClient.endTransaction();
      }
    }
    else {
      Map map = sqlMapClient.queryForMap(statementID, parameterObject,
                                         keyProperty);
      return map;

    }
  }

  /**
   *
   * @param statementID
   * @param parameterObject
   * @param keyProperty
   * @param valueProperty
   * @return
   * @throws java.lang.Exception
   */
  public Map queryForMap(String statementID, Object parameterObject,
                         String keyProperty, String valueProperty) throws
      Exception {
    if (!isStart) {
      SqlMapClient sqlMapClient = this.getSqlMapClient();
      try {
        sqlMapClient.startTransaction();
        Map map = sqlMapClient.queryForMap(statementID, parameterObject,
                                           keyProperty, valueProperty);
        sqlMapClient.commitTransaction();
        return map;
      }

      finally {
        sqlMapClient.endTransaction();
      }
    }
    else {
      Map map = sqlMapClient.queryForMap(statementID, parameterObject,
                                         keyProperty, valueProperty);
      return map;
    }
  }

  /**
   * 读取配置文件并创建SqlMapClient接口
   * @return
   * @throws java.lang.Exception
   */
	public SqlMapClient getSqlMapClient() throws Exception {
		if (resource == null || "".equalsIgnoreCase(resource))
			resource = "SqlMapConfig.xml";
		if (sqlMapClient == null) {
			Reader reader = Resources.getResourceAsReader(this.resource);
			ResourceBundle bundle = ResourceBundle.getBundle("database");
			
			String password = "";//密码
			if (null != bundle) {
				password = bundle.getString("password");
				
			}
			
			Properties properties = new Properties();
			if (password != null) {
				if(password.length() < 10){
					properties.setProperty("password", password);
				}
			}
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader,properties);
		}
    return sqlMapClient;
  }

  private String getResource() {
    return resource;
  }
  
  
  public Connection getConnection() throws Exception 
  {
	    SqlMapClient sqlMap = this.getSqlMapClient();
	    Connection db = sqlMap.getDataSource().getConnection();
	    return db;
  }
  
  public static void main(String[] args) {
	  IbatisSqlMapTemplate test = new IbatisSqlMapTemplate();
	  try {
		System.out.println(test.getConnection());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
