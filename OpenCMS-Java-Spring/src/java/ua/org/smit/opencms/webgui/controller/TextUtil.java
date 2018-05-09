/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.webgui.controller;

import java.util.ArrayList;

/**
 *
 * @author smit
 */
public class TextUtil {
    
    public String[] getSubText(String text){
        String[] list = null;
        if (text!=null && !text.isEmpty()){
            if (text.length() > 200){
                list = text.substring(0, 200).split("\n");
                return list;
            } else {
                list = text.split("\n");
                return list;
            }
        }
        
        return list; 
    }
    
}
