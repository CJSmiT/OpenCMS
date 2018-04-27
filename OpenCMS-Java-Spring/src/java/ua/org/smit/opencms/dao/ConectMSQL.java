/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class ConectMSQL {
    private static final String login = "root";
    private static final String password = "xxx";
    private static final String url = "jdbc:mysql://localhost:3306/test";
     
    public Connection getConnection(){
        try {
            Connection connection = null;
            
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
            return connection;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectMSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConectMSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        throw new RuntimeException("Err to create connect!");
    }
    
}
