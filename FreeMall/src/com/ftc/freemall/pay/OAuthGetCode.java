package com.ftc.freemall.pay;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ftc.foundation.config.DefaultParams;

public class OAuthGetCode extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//订单数据
		
		String receiverName = request.getParameter("receiverName");
		String regionCode = request.getParameter("regionCode");
		String cityCode = request.getParameter("cityCode");
		String countyCode = request.getParameter("countyCode");
		String address = request.getParameter("address");
		String receiverMobile = request.getParameter("receiverMobile");
		String prodID = request.getParameter("prodID");
		String prodName = request.getParameter("prodName");
		String price = request.getParameter("price");
		String agentID = request.getParameter("agentID");		
			
		HttpSession session = request.getSession();
		session.setAttribute("receiverName", receiverName);
		session.setAttribute("regionCode", regionCode);
		session.setAttribute("cityCode", cityCode);
		session.setAttribute("countyCode", countyCode);
		session.setAttribute("address", address);
		session.setAttribute("receiverMobile", receiverMobile);
		session.setAttribute("prodID", prodID);
		session.setAttribute("prodName", prodName);
		session.setAttribute("price", price);
		session.setAttribute("agentID", agentID);		
		
		String appid=DefaultParams.findParam("wx.appID");
		String redirectUrl=DefaultParams.findParam("yuming")+"FreeMall/PayServlet";
		String state="0";
		request.setAttribute("appid", appid);
		request.setAttribute("redirect_url",redirectUrl);
		request.setAttribute("outTradeNum", state);
		request.getRequestDispatcher("order/OAuthGetCode.jsp").forward(request, response);
	}
}
