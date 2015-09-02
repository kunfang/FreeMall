package com.ftc.freemall.service;

import java.util.List;

import com.ftc.freemall.vo.OrderVO;

public interface OrderService {
	public OrderVO searchOrderExists(OrderVO order) throws Exception;
	public void insertOrder(OrderVO order) throws Exception;
	public List<OrderVO> getOrderList(OrderVO pvo) throws Exception;
	public List<OrderVO> getAgentRanking() throws Exception;
	public List<OrderVO> getProdList() throws Exception;
}
