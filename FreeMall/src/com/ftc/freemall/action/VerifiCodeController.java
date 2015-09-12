package com.ftc.freemall.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.ftc.foundation.config.DefaultParams;
import com.ftc.foundation.util.VerifiCode;
import com.ftc.freemall.service.VerifiCodeService;
import com.ftc.freemall.vo.VerifiCodeVO;

@Controller("VerifiCodeController")
@RequestMapping("/verificode.do")
public class VerifiCodeController {
	
	@Resource
	private VerifiCodeService verifiCodeService;
	public VerifiCodeService getVerifiCodeService() {
		return verifiCodeService;
	}
	public void setVerifiCodeService(VerifiCodeService verifiCodeService) {
		this.verifiCodeService = verifiCodeService;
	}
  
	@RequestMapping(params="method=sendCode")
	public void sendVerifiCode(@RequestParam(value="receiverMobile",required=true) String receiverMobile,Model model,HttpServletResponse response, HttpSession session){
		CCPRestSmsSDK sendAPI = VerifiCode.getInstance();
		
		String verifiCode = VerifiCode.getVerifiCode();
		
		HashMap<String, Object> result = sendAPI.sendTemplateSMS(receiverMobile,DefaultParams.findParam("verificode.modleid") ,new String[]{verifiCode,DefaultParams.findParam("verificode.timelimit")});
		
		String statusCode = (String)result.get("statusCode");
		
		if(!"000000".equals(statusCode)){
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
		}
		
		PrintWriter write = null;
		try {
			/*if ("000000".equals(statusCode)) {
				VerifiCodeVO objVO = new VerifiCodeVO();
				objVO.setPhone(receiverMobile);
				objVO.setVerificode(verifiCode);
				verifiCodeService.insertVerifiCode(objVO);
			}*/
			write = response.getWriter();
			write.print(statusCode+"|"+verifiCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String checkVerifiCode() {
		return null;
	}
}
