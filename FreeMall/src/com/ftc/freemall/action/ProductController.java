package com.ftc.freemall.action;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftc.foundation.view.PageUtil;
import com.ftc.freemall.service.AgentService;
import com.ftc.freemall.service.OrderService;
import com.ftc.freemall.vo.AgentVO;
import com.ftc.freemall.vo.OrderVO;

@Controller("ProductController")
@RequestMapping("/product.do")
public class ProductController {
	private static final Logger logger = Logger.getLogger(ProductController.class);
	
	private static final String ERRORCODE_SAVED = "000000";
	private static final String ERRORCODE_ERROR = "100000";
	private static final String ERRORCODE_BUIED = "200000";
	private static final String ERRORCODE_FORMERROR = "300000";	
	
	
	@RequestMapping(params="method=getProductList") 
	public String getProductList(Model model) {
		if (logger.isDebugEnabled()) {
			logger.debug("getProductList() - start"); //$NON-NLS-1$
		}
		
		//no nothing , is forward
		
		if (logger.isDebugEnabled()) {
			logger.debug("getProductList()  - end"); //$NON-NLS-1$
		}
		return "product/ProductShareLink";
	}	
	
}
