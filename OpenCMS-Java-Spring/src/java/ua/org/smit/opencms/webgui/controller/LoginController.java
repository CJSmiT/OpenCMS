/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.webgui.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.org.smit.opencms.authorization.AuthService;
import ua.org.smit.opencms.authorization.AuthServiceImpl;

/**
 *
 * @author smit
 */
@Controller
public class LoginController {
    
    private final AuthService authService = new AuthServiceImpl();
    
    @RequestMapping(value= "/login")
    public ModelAndView login(){
        ModelAndView model = new ModelAndView("login");
        
        return model;
    }
    
    
    @RequestMapping(value= "/login_action")
    public Object loginActiron(
            @RequestParam(value = "login") String login,
            @RequestParam(value = "password") String password,
            HttpServletResponse  response) throws UnsupportedEncodingException, NoSuchAlgorithmException, InterruptedException{
        
        if(this.authService.theUserIsset(login)){
            
            if(this.authService.thePasswordCorrect(login, password)){
                
                String session = this.authService.updateUserSession(login);
                // добавляем сессию в куки пользователя
                return "redirect:home";
            } else {
                System.err.println("Wrong password");
                return "redirect:login";
            }
        } else {
            System.err.println("User not found: " + login);
            return "redirect:login";
        }
    }
    
}
