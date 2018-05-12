/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.webgui.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.org.smit.opencms.content.dao.MaterialEntityCMS;

/**
 *
 * @author smit
 */
@Controller
public class TestController {
    
    @RequestMapping(value= "/test")
    public ModelAndView test(
            HttpServletRequest request,
            HttpServletResponse  response){
        
        ModelAndView model = new ModelAndView("test");
        
        Cookie cookie1 = new Cookie("myName","myBody2");
        cookie1.setMaxAge(60*60); //1 hour
        response.addCookie(cookie1);
        
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
         for (Cookie cookie : cookies) {
           if (cookie.getName().equals("url")) {
            System.out.println(cookie.getValue());
            }
          }
        }

        return model;
    }
}
