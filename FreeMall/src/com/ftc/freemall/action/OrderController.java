package com.ftc.freemall.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ftc.foundation.view.PageUtil;
import com.ftc.freemall.service.AgentService;
import com.ftc.freemall.service.OrderService;
import com.ftc.freemall.vo.AgentVO;
import com.ftc.freemall.vo.OrderVO;
import com.ftc.freemall.vo.SalesStatisVO;

@Controller("orderController")
@RequestMapping("/order.do")
public class OrderController {
	private static final Logger logger = Logger.getLogger(OrderController.class);
	
	private static final String ERRORCODE_SAVED = "000000";
	private static final String ERRORCODE_ERROR = "100000";
	private static final String ERRORCODE_BUIED = "200000";
	private static final String ERRORCODE_FORMERROR = "300000";
	
	@Resource
	private OrderService orderService;

	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Resource
	private AgentService agentService;
	
	public AgentService getAgentService() {
		return agentService;
	}
	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}
	@RequestMapping(params="method=saveOrder") 
	public String saveOrder(OrderVO orderVO/*,@RequestParam(value="verificode",required=true) String verificode*/,HttpServletResponse response){
		if (logger.isDebugEnabled()) {
			logger.debug("saveOrder(OrderVO) - start");
		}
		
		PrintWriter write = null;
		
		String msg = ERRORCODE_SAVED;
		try {
			write = response.getWriter();
			
			if (!orderVO.checkInfo()) {
				msg = ERRORCODE_FORMERROR;
			} else {
				OrderVO result = orderService.searchOrderExists(orderVO);
				
				if (result != null) {
					msg =ERRORCODE_BUIED;
				} else {
					orderService.insertOrder(orderVO);
				}
			}
		} catch (Exception e) {
			msg =ERRORCODE_ERROR;
			e.printStackTrace();
		}
		
		write.print(msg);		
		if (logger.isDebugEnabled()) {
			logger.debug("saveOrder(OrderVO) - end"); //$NON-NLS-1$
		}
		return null;
	}
	
	@RequestMapping(params="method=getOrderList") 
	public String getOrderList(OrderVO orderVO, Model model,PageUtil pUtil) {
		if (logger.isDebugEnabled()) {
			logger.debug("getOrderList(OrderVO) - start"); //$NON-NLS-1$
		}
		
		try {
			int totalCount = orderService.getOrderCounts(orderVO);
			List<OrderVO> orderList = orderService.getOrderList(orderVO,pUtil);
			List<OrderVO> prodList = orderService.getProdList();
			List<AgentVO> agentList = agentService.getAgentList(null);
			
			PageUtil pU = new PageUtil();
			HashMap<String, Integer> pageList = pU.getPageList( pUtil.getCurPage(), totalCount,pUtil.getPageSize());
			model.addAttribute("orderList",orderList);
			model.addAttribute("agentList",agentList);
			model.addAttribute("prodList",prodList);
			model.addAttribute("pageList",pageList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("getOrderList(OrderVO) - end"); //$NON-NLS-1$
		}
		return "order/OrderList";
	}
	
	@RequestMapping(params="method=getAgentOrderList") 
	public String getAgentOrderList(OrderVO orderVO, Model model, int agentID,PageUtil pUtil) {
		if (logger.isDebugEnabled()) {
			logger.debug("getAgentOrderList(OrderVO) - start"); //$NON-NLS-1$
		}
		
		try {
			orderVO.setAgentID(agentID);
			int totalCount = orderService.getOrderCounts(orderVO);
			List<OrderVO> orderList = orderService.getOrderList(orderVO,pUtil);
			PageUtil pU = new PageUtil();
			HashMap<String, Integer> pageList = pU.getPageList( pUtil.getCurPage(), totalCount,pUtil.getPageSize());			
			List<OrderVO> prodList = orderService.getProdList();
			List<AgentVO> agentList = agentService.getAgentList(null);
			model.addAttribute("orderList",orderList);
			model.addAttribute("agentList",agentList);
			model.addAttribute("prodList",prodList);
			model.addAttribute("pageList",pageList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("getAgentOrderList(OrderVO) - end"); //$NON-NLS-1$
		}
		return "order/AgentOrderList";
	}
	
	@RequestMapping(params="method=exportCSV")
	public void exportOrderListCSV(OrderVO orderVO,HttpServletResponse response,PageUtil pUtil){
		if (logger.isDebugEnabled()) {
			logger.debug("exportOrderListCSV(OrderVO) - start"); //$NON-NLS-1$
		}
		OutputStream out = null;
		String charset = "UTF-8";
		try {
			String csvFileName = "orders.csv";
			response.setContentType("text/csv");
			
			// creates mock data
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"",csvFileName);
	        response.setHeader(headerKey, headerValue);
	        
	        out = response.getOutputStream();
	        out.write(new byte[]{(byte)0xEF,(byte)0xBB,(byte)0xBF});
			List<OrderVO> orderList = orderService.getOrderList(orderVO,pUtil);
			
			String header = "序号,接受人姓名,省份,城市,县,地址,手机,提交时间,产品名称,代理";
			header = "\"" + header.replaceAll(",", "\",\"") + "\"\r\n";
			out.write(header.getBytes(charset));
			StringBuffer sbf=new StringBuffer();
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			for (OrderVO order:orderList) {
				sbf.append("\"").append(order.getOrderID()).append("\"");
				sbf.append(",");
				sbf.append("\"").append(order.getReceiverName()).append("\"");
				sbf.append(",");
				sbf.append("\"").append(order.getRegionCode()).append("\"");
				sbf.append(",");
				sbf.append("\"").append(order.getCityCode()).append("\"");
				sbf.append(",");
				sbf.append("\"").append(order.getCountyCode()).append("\"");
				sbf.append(",");
				sbf.append("\"").append(order.getAddress()).append("\"");
				sbf.append(",");
				sbf.append("\"").append(order.getReceiverMobile()).append("\"");
				sbf.append(",");
				sbf.append("\"").append(format.format(order.getCreateDate())).append("\"");
				sbf.append(",");
				sbf.append("\"").append(order.getProdName()).append("\"");
				sbf.append(",");
				sbf.append("\"").append(order.getAgentName()).append("\"");
				sbf.append("\n");
			}
			
			out.write(sbf.toString().getBytes(charset));
			
			try{out.flush();}catch(Exception ex){}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{out.close();}catch(Exception ex){}
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("exportOrderListCSV(OrderVO) - end"); //$NON-NLS-1$
		}
	}
	
	@RequestMapping(params="method=exportAgentCSV")
	public void exportAgentCSV(OrderVO orderVO,HttpServletResponse response,PageUtil pUtil){
		if (logger.isDebugEnabled()) {
			logger.debug("exportAgentCSV(OrderVO) - start"); //$NON-NLS-1$
		}
		OutputStream out = null;
		String charset = "UTF-8";
		try {
			String csvFileName = "orders.csv";
			response.setContentType("text/csv");
			
			// creates mock data
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"",csvFileName);
	        response.setHeader(headerKey, headerValue);
	        
	        out = response.getOutputStream();
	        out.write(new byte[]{(byte)0xEF,(byte)0xBB,(byte)0xBF});
			List<OrderVO> orderList = orderService.getOrderList(orderVO,pUtil);
			
			String header = "序号,接受人姓名,省份,城市,县,提交时间,产品名称";
			header = "\"" + header.replaceAll(",", "\",\"") + "\"\r\n";
			out.write(header.getBytes(charset));
			StringBuffer sbf=new StringBuffer();
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			for (OrderVO order:orderList) {
				sbf.append("\"").append(order.getOrderID()).append("\"");
				sbf.append(",");
				sbf.append("\"").append(order.getReceiverName()).append("\"");
				sbf.append(",");
				sbf.append("\"").append(order.getRegionCode()).append("\"");
				sbf.append(",");
				sbf.append("\"").append(order.getCityCode()).append("\"");
				sbf.append(",");
				sbf.append("\"").append(order.getCountyCode()).append("\"");
				sbf.append(",");
				/*sbf.append("\"").append(order.getAddress()).append("\"");
				sbf.append(",");
				sbf.append("\"").append(order.getReceiverMobile()).append("\"");
				sbf.append(",");*/
				sbf.append("\"").append(format.format(order.getCreateDate())).append("\"");
				sbf.append(",");
				sbf.append("\"").append(order.getProdName()).append("\"");
				/*sbf.append(",");
				sbf.append("\"").append(order.getAgentName()).append("\"");*/
				sbf.append("\n");
			}
			
			out.write(sbf.toString().getBytes(charset));
			
			try{out.flush();}catch(Exception ex){}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{out.close();}catch(Exception ex){}
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("exportAgentCSV(OrderVO) - end"); //$NON-NLS-1$
		}
	}
	
	@RequestMapping(params="method=getAgentRanking")
	public String getAgentRanking(Model model) {
		if (logger.isDebugEnabled()) {
			logger.debug("getAgentRanking(model) - start"); //$NON-NLS-1$
		}
		
		try {
			
			List<OrderVO> agentList = orderService.getAgentRanking();
			List<OrderVO> prodList = orderService.getProdList();
			model.addAttribute("agentList",agentList);
			model.addAttribute("prodList",prodList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("getAgentRanking(model) - end"); //$NON-NLS-1$
		}
		return "order/AgentRanking";
	}
	
	@RequestMapping(params="method=getSalesStatis")
	public void getSalesStatis(HttpServletResponse response,@RequestParam(value="userid",required=true) int userid){
		if (logger.isDebugEnabled()) {
			logger.debug("getSalesStatis(response,userid) - start"); //$NON-NLS-1$
		}
		
		try {
			List<SalesStatisVO> result = orderService.getSalesStatis(userid);
			
			int size = result.size();
			String[] categories = new String[size];
			Integer[] values = new Integer[size];
			
			for (int i=0;i<size;i++) {
				SalesStatisVO sales = result.get(i);
				categories[i] = sales.getDay();
				values[i] = sales.getNum();
			}
			
			Map<String, Object> json = new HashMap<String, Object>();  
			json.put("categories", categories);  
			json.put("values", values);
			
			System.out.println(JSONObject.fromObject(json));
			response.getWriter().print(JSONObject.fromObject(json));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("getSalesStatis(response,userid) - end"); //$NON-NLS-1$
		}
	}
}
