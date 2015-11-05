package com.ftc.freemall.pay;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.jdom.JDOMException;

import com.ftc.foundation.config.DefaultParams;

public class PayServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest httpRequest, HttpServletResponse response)
			throws ServletException, IOException {
		String code = httpRequest.getParameter("code");
		//订单数据
		HttpSession session = httpRequest.getSession();
		String prodName = (String)session.getAttribute("prodName");
		httpRequest.setAttribute("receiverName", session.getAttribute("receiverName"));
		httpRequest.setAttribute("regionCode", session.getAttribute("regionCode"));
		httpRequest.setAttribute("cityCode", session.getAttribute("cityCode"));
		httpRequest.setAttribute("countyCode", session.getAttribute("countyCode"));
		httpRequest.setAttribute("address", session.getAttribute("address"));
		httpRequest.setAttribute("receiverMobile", session.getAttribute("receiverMobile"));
		httpRequest.setAttribute("prodID", session.getAttribute("prodID"));
		httpRequest.setAttribute("prodName", prodName);
		httpRequest.setAttribute("price", session.getAttribute("price"));
		httpRequest.setAttribute("agentID", session.getAttribute("agentID"));
		
		String returnJSON=HttpTool.getToken(DefaultParams.findParam("wx.appID"), DefaultParams.findParam("wx.appsecret"), "authorization_code", code);
		JSONObject obj = JSONObject.fromObject(returnJSON);
		System.out.println(obj);
		String openid=obj.get("openid").toString();
		String out_trade_num=System.currentTimeMillis()+"";
		Map<String, String> wxPayParamMap = null;
		String spbill_create_ip = httpRequest.getRemoteAddr();
		try {
			wxPayParamMap = WXJSPay.jsApiPay(openid, "1",out_trade_num,spbill_create_ip,prodName);//测试金额为1分钱
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		httpRequest.setAttribute("appId", wxPayParamMap.get("appId"));
		httpRequest.setAttribute("timeStamp", wxPayParamMap
				.get("timeStamp"));
		httpRequest.setAttribute("nonceStr", wxPayParamMap
				.get("nonceStr"));
		httpRequest.setAttribute("wxPackage", wxPayParamMap
				.get("package"));
		httpRequest.setAttribute("signType", wxPayParamMap
				.get("signType"));
		httpRequest.setAttribute("paySign", wxPayParamMap
				.get("paySign"));
		httpRequest.setAttribute("payMoney", wxPayParamMap
				.get("payMoney"));
		httpRequest.setAttribute("openid",openid);
		httpRequest.setAttribute("orderCode",out_trade_num);
		httpRequest.getRequestDispatcher("order/OrderPay.jsp").forward(httpRequest, response);
	}

}
