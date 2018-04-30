/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.dao;

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
    private static final String LOGIN = getPropertiesMethod().getProperty("login");
    private static final String PASSWORD = getPropertiesMethod().getProperty("password");
    private static final String URL = "jdbc:mysql://" + getPropertiesMethod().getProperty("address_port_db");  //localhost:3306/test
    
    public Connection getConnection(){
        try {
            Connection connection = null;
            
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            return connection;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectMSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConectMSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        throw new RuntimeException("Err to create connect!");
    }
    
    private static Properties getPropertiesMethod(){
        Properties properties = new Properties();
        try {
            FileInputStream in = new FileInputStream("/home/alex/db.properties"); 
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
