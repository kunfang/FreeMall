package com.ftc.freemall.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ftc.foundation.dao.DefaultDAO;
import com.ftc.freemall.service.UserService;
import com.ftc.freemall.vo.User;
@Service("uservice") 
public class UserServiceImpl implements UserService{
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Resource
    private DefaultDAO dao;
	public DefaultDAO getDao() {
		return dao;
	}
	public void setDao(DefaultDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<User> checkLogin(User user) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("checkLogin(User) - start"); //$NON-NLS-1$
		}

		List<User> list = new ArrayList<User>();
		list = dao.toList("user.getUserByCode",user.getUsername());

		if (logger.isDebugEnabled()) {
			logger.debug("checkLogin(User) - end"); //$NON-NLS-1$
		}
		return list;
	}
	
	/**
	 * 通过用户代码获取用户信息
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public User toView(String userid) throws Exception{
		if (logger.isDebugEnabled()) {
			logger.debug("toView(String) - start"); //$NON-NLS-1$
		}

		User user = new User();
		if(userid == null || userid.trim().equals(""))
		{
			if (logger.isDebugEnabled()) {
				logger.debug("toView(String) - end"); //$NON-NLS-1$
			}
			return null;
		}

		List<User> list = new ArrayList<User>();
		list = dao.toList("user.getUserById",userid);
		if(list != null && !list.isEmpty())
		{
			user = list.get(0);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("toView(String) - end"); //$NON-NLS-1$
		}
		return user;
	}
	
	/**
	 * 修改用户信息
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public int doUpdate(User vo) throws Exception
	{
		if (logger.isDebugEnabled()) {
			logger.debug("doUpdate(User) - start"); //$NON-NLS-1$
		}

		int returnint = dao.doUpdate("user.doUpdate", vo);
		if (logger.isDebugEnabled()) {
			logger.debug("doUpdate(User) - end"); //$NON-NLS-1$
		}
		return returnint;
	}

}
