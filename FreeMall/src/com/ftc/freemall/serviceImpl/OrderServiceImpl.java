package com.ftc.freemall.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ftc.foundation.dao.DefaultDAO;
import com.ftc.freemall.service.OrderService;
import com.ftc.freemall.vo.OrderVO;

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
	public List<OrderVO> getOrderList(OrderVO order) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("getOrderList(OrderVO) - start"); //$NON-NLS-1$
		}
		List<OrderVO> orderList = null;
			try {
			     dao.startTransaction();
			     orderList = (List<OrderVO>)dao.toList("order.getOrderList", order);
				 
			} catch (Exception e) {
				dao.endTransaction();
				e.printStackTrace();
			}finally{
				dao.commitTransation();
			}
			
		if (logger.isDebugEnabled()) {
			logger.debug("getOrderList(OrderVO) - end"); //$NON-NLS-1$
		}
		return orderList;
	}

}
