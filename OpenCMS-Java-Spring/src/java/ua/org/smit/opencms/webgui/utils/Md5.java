/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.webgui.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smit
 */
public class Md5 {
    
    public static String getHash(String text){
        try {
            byte[] bytesOfMessage = text.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            BigInteger bigInt = new BigInteger(1, thedigest);
            String stringHashed = bigInt.toString(16);
            
            return stringHashed;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Md5.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("HASH ERR");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Md5.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("HASH ERR");
        }
    }
}
