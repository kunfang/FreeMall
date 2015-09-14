package com.ftc.freemall.action;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
			request.getSession().setAttribute("userInfo", listAllUser.get(0));
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorInfo","Login Error!!!");
			return "login";
		} 
		
		if (logger.isDebugEnabled()) {
			logger.debug("getAssessSysMenubyList(ProductVO) - end"); //$NON-NLS-1$
		}

		
		return "redirect:order.do?method=getAgentRanking";  
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
	
	/**
     *@param  [HttpServletRequest] [绑定属性值]
     *@return  [返回需要跳转的页面名称]
     *@description [系统退出]
     */
	@RequestMapping(params="method=logout") 
	public String logout(HttpServletRequest request){
		if (logger.isDebugEnabled()) {
			logger.debug("logout(HttpServletRequest) - start"); //$NON-NLS-1$
		}
		clearSession(request);
		request.getSession().invalidate();
		if (logger.isDebugEnabled()) {
			logger.debug("logout(HttpServletRequest) - end"); //$NON-NLS-1$
		}
		return "login";
	}
	
	/**
     *@param  [HttpServletRequest] [获取Session会话]
     *@description [清空登录的Session值]
     */
	public void clearSession(HttpServletRequest request) {
		if (logger.isDebugEnabled()) {
			logger.debug("clearSession(HttpServletRequest) - start"); //$NON-NLS-1$
		}
		HttpSession session = request.getSession();
		if (session.getAttribute("userID") != null)
			session.removeAttribute("userID"); //移除登录用户名;
		if (session.getAttribute("oldPass") != null)
			session.removeAttribute("oldPass"); //移除密码;
		if (session.getAttribute("trueName") != null) 
			session.removeAttribute("trueName"); //移除真实姓名;
		if (session.getAttribute("dptName") != null)
			session.removeAttribute("dptName"); //移除部门;

		if (logger.isDebugEnabled()) {
			logger.debug("clearSession(HttpServletRequest) - end"); //$NON-NLS-1$
		}
	}
	
	/**
     *@param  [String,HttpServletRequest,HttpServletResponse] [是否修改密码,绑定属性值,错误信息返回到页面]
     *@return  [返回需要跳转的页面名称]
     *@description [密码修改]
     */
	@RequestMapping(params="method=pwd") 
	public String pwd(String isnew,HttpServletRequest request,HttpServletResponse response){
		if (logger.isDebugEnabled()) {
			logger.debug("doChangePwd(ActionParameter) - start"); //$NON-NLS-1$
		}
		
		if(!"".equals(isnew) && "Y".equals(isnew)){
			return "updatePsd";
		}else{
			String userid =String.valueOf((Integer)request.getSession().getAttribute("userId"));
			String oldpass=request.getParameter("oldPsd");
			String newpass=request.getParameter("newPsd");
			if(userid!=null && !"".equals(userid)){
				try {
					User user =asms.toView(userid);
					String pass=user.getPassword();
					String retStr = "";
					
					if(pass.equals(this.encryPass(oldpass))){
						User users=new User();
						users.setPassword(this.encryPass(newpass));
						users.setUserid(Integer.parseInt(userid));
						int flag = asms.doUpdate(users);
						if(flag == 1)
						{
							retStr = "1";//密码修改成功
						}
						else
						{
							retStr = "2";	  //密码修改失败
						}
					}
					else
					{
						retStr = "0";//原始密码输入错误
					}
					response.setContentType("text/html; charset=UTF-8");
					response.getWriter().write(retStr);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			if (logger.isDebugEnabled()) {
				logger.debug("doChangePwd(ActionParameter) - end"); //$NON-NLS-1$
			}
			
			return null;
		}
		
	}
	
	/**
     *@param  [User,Model,HttpServletRequest] [当前登录驻点员,绑定属性值,获取Session会话]
     *@return  [返回需要跳转的页面名称]
     *@description [用户注册]
     */
	@RequestMapping(params="method=registerUser") 
	public String registerUser(com.ftc.freemall.vo.User user,Model model,HttpServletRequest request){
		if (logger.isDebugEnabled()) {
			logger.debug("registerUser(User) - start"); //$NON-NLS-1$
		}
		String result="registerUser";
		try{
			if(user.getUsername()!=null && !"".equals(user.getUsername())){
				user.setPassword(this.encryPass(user.getPassword()));
				uservice.doInsert(user);
				result="login";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("registerUser(User) - end"); //$NON-NLS-1$
		}
		return result;
	}
	
	/**
     *@param  [User,Model,HttpServletRequest] [当前登录驻点员,绑定属性值,获取Session会话]
     *@return  [返回需要跳转的页面名称]
     *@description [用户注册]
     */
	@RequestMapping(params="method=checkUserName") 
	public void checkUserName(String username,Model model,HttpServletRequest request,HttpServletResponse response){
		if (logger.isDebugEnabled()) {
			logger.debug("checkUserName(User) - start"); //$NON-NLS-1$
		}
		String str="1";
		try{
			if(username!=null && !"".equals(username)){
				int result=uservice.getUserByUsername(username);
				if(result>0){
					str="2";
				}
			}
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().write(str);
		}catch(Exception e){
			e.printStackTrace();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("checkUserName(User) - end"); //$NON-NLS-1$
		}
	}

}
