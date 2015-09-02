package com.ftc.freemall.service;

import java.util.List;

import com.ftc.freemall.vo.User;

public interface UserService {
	
	public List<User> checkLogin(User user) throws Exception; 
}
