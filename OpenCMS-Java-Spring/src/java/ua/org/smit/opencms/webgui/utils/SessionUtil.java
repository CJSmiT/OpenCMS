/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.webgui.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author smit
 */
public class SessionUtil {
    
    private static final String COOKIE_NAME = "SESSION";
    
    public static String getSession(HttpServletRequest request){
        String session = null;
        
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
         for (Cookie cookie : cookies) {
           if (cookie.getName().equals(COOKIE_NAME)) {
                session = cookie.getValue();
            }
          }
        }
        
        return session;
    }

    public static void setSession(String session, HttpServletResponse  response) {
        Cookie cookie1 = new Cookie(COOKIE_NAME,session);
        cookie1.setMaxAge(60*60*60); //1 hour
        response.addCookie(cookie1);
    }
}
