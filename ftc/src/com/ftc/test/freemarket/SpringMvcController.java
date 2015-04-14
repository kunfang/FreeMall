package com.ftc.test.freemarket;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMvcController {

    @RequestMapping(value="/welcome",method={RequestMethod.GET}) 
    public ModelAndView getFirstPage(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("welcome");
        mv.addObject("name", "My First Spring Mvc");
        System.out.println("this is get request");
        return mv;
    }
}