/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.authorization;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author smit
 */
public class ConverterByComa {
    
    public static ArrayList<String> stringToLis(String text){
        ArrayList<String> list = new ArrayList();
        String[] array = text.split(",");
        
        list.addAll(Arrays.asList(array));
        
        return list;
    }
    
    public static String listToString(ArrayList<String> list){
        String text = "";
        
        for(String line : list){
            text += line + ",";
        }
        
        if(text.length() > 0){
            text = text.substring(0, text.length() -1);
        }
        return text;
    }
    
}
