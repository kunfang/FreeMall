package com.ftc.freemall.service;

import java.util.List;

import com.ftc.foundation.view.PageUtil;
import com.ftc.freemall.vo.OrderVO;
import com.ftc.freemall.vo.SalesStatisVO;

public interface OrderService {
	public OrderVO searchOrderExists(OrderVO order) throws Exception;
	public void insertOrder(OrderVO order) throws Exception;
	public List<OrderVO> getOrderList(OrderVO pvo,PageUtil pUtil) throws Exception;
	public List<OrderVO> getAgentRanking() throws Exception;
	public List<OrderVO> getProdList() throws Exception;
	public int getOrderCounts(OrderVO order) throws Exception;
	public List<SalesStatisVO> getSalesStatis(int agentid) throws Exception;
}
