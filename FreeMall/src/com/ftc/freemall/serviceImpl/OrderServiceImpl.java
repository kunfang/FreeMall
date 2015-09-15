package com.ftc.freemall.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ftc.foundation.dao.DefaultDAO;
import com.ftc.foundation.view.PageUtil;
import com.ftc.freemall.service.OrderService;
import com.ftc.freemall.vo.OrderVO;
import com.ftc.freemall.vo.SalesStatisVO;

@Service("orderService") 
public class OrderServiceImpl implements OrderService {
	private static final Logger logger = Logger.getLogger(OrderServiceImpl.class);
	
	@Resource
	private DefaultDAO dao;
	public DefaultDAO getDao() {
		return dao;
	}
	
	public void setDao(DefaultDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public OrderVO searchOrderExists(OrderVO order)  throws Exception{
		if (logger.isDebugEnabled()) {
			logger.debug("insertProduct(ProductPageVO) - start"); //$NON-NLS-1$
		}
		
		OrderVO result=(OrderVO)dao.toView("order.checkFrist", order);
		
		if (logger.isDebugEnabled()) {
			logger.debug("insertProduct(ProductPageVO) - end"); //$NON-NLS-1$
		}
		return result;
	}

	@Override
	public void insertOrder(OrderVO order)  throws Exception{
		if (logger.isDebugEnabled()) {
			logger.debug("insertProduct(ProductPageVO) - start"); //$NON-NLS-1$
		}
			try {
			     dao.startTransaction();
				 
				 dao.doInsertResult("order.doInsert", order);
			} catch (Exception e) {
				dao.endTransaction();
				e.printStackTrace();
			}finally{
				dao.commitTransation();
			}
		if (logger.isDebugEnabled()) {
			logger.debug("insertProduct(ProductPageVO) - end"); //$NON-NLS-1$
		}
	
}

	@Override
	public List<OrderVO> getOrderList(OrderVO order,PageUtil pUtil) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("getOrderList(OrderVO) - start"); //$NON-NLS-1$
		}
		List<OrderVO> orderList = null;
		     
			     String sqlWhere="";
			     
			     if(order.getRegionCode()!=null && !"".equals(order.getRegionCode())){
						sqlWhere +=" and a.regionCode like '"+order.getRegionCode().trim()+"'";
				 }
			     if(order.getCityCode()!=null && !"".equals(order.getCityCode())){
						sqlWhere +=" and a.cityCode like '"+order.getCityCode().trim()+"'";
				 }
			     if(order.getProdName()!=null && !"".equals(order.getProdName())){
						sqlWhere +=" and a.prodName like '"+order.getProdName().trim()+"'";
				 }
			     if(order.getBeginTime()!=null && !"".equals(order.getBeginTime())){
						sqlWhere +=" and a.createdate >= str_to_date('"+order.getBeginTime().trim()+"','%Y-%m-%d %H:%i:%s') ";
				 }
			     if(order.getEndTime()!=null && !"".equals(order.getEndTime())){
						sqlWhere +=" and a.createdate <= str_to_date('"+order.getEndTime().trim()+"','%Y-%m-%d %H:%i:%s') ";
				 }
			     if(order.getAgentName()!=null && !"".equals(order.getAgentName())){
						sqlWhere +=" and b.username like '"+order.getAgentName().trim()+"'";
				 }
			     if(order.getAgentID()!=null && order.getAgentID().intValue() != 1){
						sqlWhere +=" and b.userid = "+order.getAgentID();
				 }
			     
			     String orderBySqlString = " order by a.createdate desc ";
			     sqlWhere += orderBySqlString + "  limit "+((pUtil.getCurPage()-1)*pUtil.getPageSize())+","+pUtil.getPageSize();
			    
			     orderList = (List<OrderVO>)dao.toList("order.getPageOrderList", sqlWhere);
				
			
		if (logger.isDebugEnabled()) {
			logger.debug("getOrderList(OrderVO) - end"); //$NON-NLS-1$
		}
		return orderList;
	}
	@Override
	public int getOrderCounts(OrderVO order) throws Exception {
		// TODO Auto-generated method stub
				if (logger.isDebugEnabled()) {
					logger.debug("getLogCounts(OrderVO order) - start"); //$NON-NLS-1$
				}
				int totalCount = 0;
				
				try {
				     dao.startTransaction();				    
				     
				     totalCount = dao.getTotalPageCount("order.getOrderPageCounts", order);
				     System.out.println("totalCount="+totalCount);
					 
				} catch (Exception e) {
					dao.endTransaction();
					e.printStackTrace();
				}finally{
					dao.commitTransation();
				}
				
				
				
				if (logger.isDebugEnabled()) {
					logger.debug("getLogCounts(OrderVO order) - end"); //$NON-NLS-1$
				}
				return totalCount;
	}

	@Override
	public List<OrderVO> getAgentRanking() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("getAgentRanking() - start"); //$NON-NLS-1$
		}
		List<OrderVO> orderList = null;
			try {
			     dao.startTransaction();
			     orderList = (List<OrderVO>)dao.toList("order.getAgentRanking",null);
				 
			} catch (Exception e) {
				dao.endTransaction();
				e.printStackTrace();
			}finally{
				dao.commitTransation();
			}
			
		if (logger.isDebugEnabled()) {
			logger.debug("getAgentRanking() - end"); //$NON-NLS-1$
		}
		return orderList;
	}

	@Override
	public List<OrderVO> getProdList() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("getProdList() - start"); //$NON-NLS-1$
		}
		List<OrderVO> prodList = null;
			try {
			     dao.startTransaction();
			     prodList = (List<OrderVO>)dao.toList("order.getProdList",null);
				 
			} catch (Exception e) {
				dao.endTransaction();
				e.printStackTrace();
			}finally{
				dao.commitTransation();
			}
			
		if (logger.isDebugEnabled()) {
			logger.debug("getProdList() - end"); //$NON-NLS-1$
		}
		return prodList;
	}

	@Override
	public List<SalesStatisVO> getSalesStatis(int agentid) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("getSalesStatis(agentid) - start"); //$NON-NLS-1$
		}
		List<SalesStatisVO> statisList = null;
		try {
			OrderVO order = new OrderVO();
			order.setAgentID(agentid);
		    dao.startTransaction();
		    statisList = (List<SalesStatisVO>)dao.toList("order.getSalesStatis",order);
			 
		} catch (Exception e) {
			dao.endTransaction();
			e.printStackTrace();
		}finally{
			dao.commitTransation();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("getSalesStatis(agentid) - end"); //$NON-NLS-1$
		}
		return statisList;
	}

}
