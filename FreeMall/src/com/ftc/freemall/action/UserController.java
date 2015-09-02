package com.ftc.freemall.action;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftc.freemall.service.SysMenuService;
import com.ftc.freemall.service.UserService;
import com.ftc.freemall.vo.SysMenuVO;
import com.ftc.freemall.vo.User;
@Controller("userController")
@RequestMapping("/userLoginlist.do")
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Resource
	private UserService uservice;
	public UserService getUservice() {
		return uservice;
	}
	public void setUservice(UserService uservice) {
		this.uservice = uservice;
	}
	
	@Resource
	private SysMenuService asms;
	public SysMenuService getAsms() {
		return asms;
	}
	public void setAsms(SysMenuService asms) {
		this.asms = asms;
	}
	
	/**
     *@param  [User,Model,HttpServletRequest] [当前登录驻点员,绑定属性值,获取Session会话]
     *@return  [返回需要跳转的页面名称]
     *@description [获得菜单清单]
     */
	@RequestMapping(params="method=getAssessSysMenubyList") 
	public String getAssessSysMenubyList(com.ftc.freemall.vo.User user,Model model,HttpServletRequest request) {
		if (logger.isDebugEnabled()) {
			logger.debug("getAssessSysMenubyList(ProductVO) - start"); //$NON-NLS-1$
		}
		try {
			List<User> listAllUser =uservice.checkLogin(user);
			if (listAllUser==null || listAllUser.size() == 0) { //该用户无效!
				request.getSession().setAttribute("loginErrInfo", "该用户不存在或非终端用户!");
				if (logger.isDebugEnabled()) {
					logger.debug("getAssessSysMenubyList(User,Model,HttpServletRequest) - end"); //$NON-NLS-1$
				}
				return "login";
			}else{
				String loginPass = user.getPassword(); //用户输入的密码
				if (loginPass == null || loginPass.equalsIgnoreCase(""))
					loginPass = "6666";
				if (listAllUser.get(0) != null &&
						!listAllUser.get(0).getPassword().equalsIgnoreCase(this.encryPass(loginPass))
						) {
					request.getSession().setAttribute("loginErrInfo", "用户名或者密码错误!");
					if (logger.isDebugEnabled()) {
						logger.debug("login(ActionParameter) - end"); //$NON-NLS-1$
					}
					return "login";
				}
			
			}
			
			List<SysMenuVO> list=asms.selectAssessSysMenu(user.getUsername());
			request.getSession().setAttribute("menuList", list);
			request.getSession().setAttribute("userId", listAllUser.get(0).getUserid());
			request.getSession().setAttribute("trueName", listAllUser.get(0).getUsername());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorInfo","Login Error!!!");
			return "login";
		} 
		
		if (logger.isDebugEnabled()) {
			logger.debug("getAssessSysMenubyList(ProductVO) - end"); //$NON-NLS-1$
		}

		
		return "index";  
	}
	
	/**
     *@param  [String] [输入的密码]
     *@return  [加密后的密码]
     *@exception [加密方式异常]
     *@description [密码加密]
     */
	private String encryPass(String pass) throws NoSuchAlgorithmException {
		if (logger.isDebugEnabled()) {
			logger.debug("encryPass(String) - start"); //$NON-NLS-1$
		}
		byte[] digest=new byte[1024];
    	String result="";
    	try {   
    	     MessageDigest md5 = MessageDigest.getInstance("MD5");
    	     md5.update(pass.getBytes());     // 添加要计算的摘要信息   
    	     digest = md5.digest();
    	 }catch(NoSuchAlgorithmException e) {   
    	     e.printStackTrace(); 
    	 } 
    	
    	for(int i=0;i<digest.length;i++) 
    	 {   
    		     result+=(Integer.toHexString(digest[i] & 0XFF));   
    	 }
    	    return result.toLowerCase(); 
	}
	

}
