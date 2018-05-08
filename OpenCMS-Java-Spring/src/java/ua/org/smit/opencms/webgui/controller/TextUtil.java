/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.webgui.controller;

/**
 *
 * @author smit
 */
public class TextUtil {
    
    public String getSubText(String text){
        if (text!=null && !text.isEmpty()){
            if (text.length()>200){
                return text.substring(0, 200);
            } else {
                return text;
            }
        }
        
        return "";
        
    }
}
