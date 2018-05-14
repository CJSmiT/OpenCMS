/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.authorization.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.usertype.UserType;
import ua.org.smit.opencms.authorization.UserAuth;
import ua.org.smit.opencms.content.dao.ConectMSQL;

/**
 *
 * @author alex
 */
public class DaoLayeUserAuth extends ConectMSQL{
    
    private final String table = "user";
    
    public UserAuth getUserBySession(String session) {
        Connection connect = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM " + table + " WHERE session=? limit 1";
        UserAuth userAuth = null;
        try{
            
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1,session);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                userAuth = getByParser(resultSet);
            }
            
            
        }catch(SQLException ex){
            Logger.getLogger(DaoLayeUserAuth.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                preparedStatement.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayeUserAuth.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(userAuth != null){
            return userAuth;
        }else
        {
            throw new RuntimeException("Err to get userAuth by '" + session + "' !");
        }
    }


    public UserAuth getUserByLogin(String login) {
        Connection connect = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM " + table + " WHERE login=? limit 1";
        UserAuth userAuth = null;
        try{
            
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1,login);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                userAuth = getByParser(resultSet);
            }
            
            
        }catch(SQLException ex){
            Logger.getLogger(DaoLayeUserAuth.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                preparedStatement.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayeUserAuth.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(userAuth != null){
            return userAuth;
        }else
        {
            throw new RuntimeException("Err to get userAuth by '" + login + "' !");
        }
    }


    public void updateUser(UserAuth user) {
        Connection connect = getConnection();
        PreparedStatement ps = null;
        try {
            String query = "UPDATE `" + table + "` "
                    + "SET login=?,"
                    //+ "type=?,"
                    + "session =?,"
                    + "password=?,"
                    + "WHERE id='"+user.getId()+"' "
                    + "limit 1";
            ps = connect.prepareStatement(query);
            ps.setString(1, user.getLogin());
            //ps.set(2, user.getType());
            ps.setString(3, user.getSession());
            ps.setString(4, user.getPassword());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoLayeUserAuth.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayeUserAuth.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    
    }
    

    private UserAuth getByParser(ResultSet resultSet) {
        try {
            UserAuth userAuth = new UserAuth();
            
            userAuth.setId(resultSet.getInt("id"));
            userAuth.setLogin(resultSet.getString("login"));
            userAuth.setPassword(resultSet.getString("password"));
            userAuth.setSession(resultSet.getString("session"));         
           // userAuth.setType((UserType)resultSet.getType());//???
            
            
            return userAuth;
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoLayeUserAuth.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new RuntimeException("Err to get UserAuth");
    }
    
}
