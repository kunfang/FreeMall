package com.ftc.foundation.wx;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ftc.freemall.vo.OrderVO;

@Controller("wxController")
@RequestMapping("/wx.do")
public class WXInterfaceActions {
	private static final Logger logger = Logger.getLogger(WXInterfaceActions.class);
	
	@RequestMapping(params="method=checkSignature")
	public void checkSignature(HttpServletRequest request,HttpServletResponse response) {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (WXUtil.checkSignature(signature, timestamp, nonce)){
				out.print(echostr);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
			out = null;
		}
		
	}	
	
	@RequestMapping(params="method=pageConfig")
	public void getItemPage(@RequestParam(value="url",required=true) String url,HttpServletResponse response) {
		if (logger.isDebugEnabled()) {
			logger.debug("getItemPage(url) - start"+url);
		}
		
		String jsapi_ticket = WXUtil.getTicket();
		
		Map<String,String> map = WXUtil.sign(jsapi_ticket, url);
		
		PrintWriter write = null;
		try {
			write = response.getWriter();
			write.print(JSONObject.fromObject(map));
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e);
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("getItemPage(url) - end"+url);
		}
	}
	
	/**
	 * pre_payid
	 * @param ov
	 */
	public void Unifiedorder(OrderVO ov) {
		
	}
	
	public static void main(String[] args) {
		System.out.println(new Date().getTime());
	}
}
