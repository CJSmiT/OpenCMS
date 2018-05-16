/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.content.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class ConectMSQL {
    private static final Properties PROPERTIES = getPropertiesMethod();
    private static final String LOGIN = PROPERTIES.getProperty("login");
    private static final String PASSWORD = PROPERTIES.getProperty("password");
    private static final String URL = "jdbc:mysql://" 
            + PROPERTIES.getProperty("address") + ":" 
            + PROPERTIES.getProperty("port") + "/" 
            + PROPERTIES.getProperty("db");
    
    public Connection getConnection(){
        try {
            Connection connection;
            
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConectMSQL.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        throw new RuntimeException("Err to create connect!");
    }
    
    private static Properties getPropertiesMethod(){
        Properties properties = new Properties();
        try {
            FileInputStream in = new FileInputStream("/home/alex/tmp/db.properties"); 
            properties.load(in);
            return properties;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConectMSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConectMSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new RuntimeException("Error properties file");
    }
    
}
