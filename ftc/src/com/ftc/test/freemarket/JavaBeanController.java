package com.ftc.test.freemarket;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ftc.test.vo.User;

@Controller
public class JavaBeanController {
	
	@RequestMapping(value="/userinfo",method={RequestMethod.GET}) 
	public ModelAndView getFirstPage(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("userInfo");
        
        User user = new User();
        user.setPassword("oval163");
        user.setUserName("kun.fang");
        
        mv.addObject("user", user);
        return mv;
    }
}
