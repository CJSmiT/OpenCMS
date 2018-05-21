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
import ua.org.smit.opencms.authorization.UserAuth;
import ua.org.smit.opencms.authorization.UserType;
import ua.org.smit.opencms.content.dao.ConectMSQL;

/**
 *
 * @author alex
 */
public class DaoLayeUserAuth extends ConectMSQL{
    
    private final String table = "user";
    
    public UserAuthDto getUserBySession(String session) {
        Connection connect = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM " + table + " WHERE session=? limit 1";
        UserAuthDto userAuth = null;
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


    public UserAuthDto getUserByLogin(String login) {
        Connection connect = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM " + table + " WHERE login=? limit 1";
        UserAuthDto userAuth = null;
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


    public void updateUser(UserAuthDto user) {
        Connection connect = getConnection();
        PreparedStatement ps = null;
        try {
            String query = "UPDATE `" + table + "` "
                    + "SET login=?,"
                    + "type=?, "
                    + "session=?, "
                    + "password=?, "
                    + "groups=? "
                    + "WHERE id='"+user.getId()+"' "
                    + "limit 1";
            //UPDATE `user` SET `login`='alex',`password`='e10adc3949ba59abbe56e057f20f883e', `session`='111',`type`='MEMBER' WHERE `id`='2' LIMIT 1
            ps = connect.prepareStatement(query);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getType().toString().toUpperCase());
            ps.setString(3, user.getSession());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getGroups());
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
    

    private UserAuthDto getByParser(ResultSet resultSet) {
        try {
            UserAuthDto userAuthDto = new UserAuthDto();
            
            userAuthDto.setId(resultSet.getInt("id"));
            userAuthDto.setLogin(resultSet.getString("login"));
            userAuthDto.setPassword(resultSet.getString("password"));
            userAuthDto.setSession(resultSet.getString("session"));         
            userAuthDto.setType(resultSet.getString("type").toUpperCase());
            userAuthDto.setGroups(resultSet.getString("groups"));
            
            return userAuthDto;
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoLayeUserAuth.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new RuntimeException("Err to get UserAuth");
    }

    boolean checkUserInDb(String login) {
        boolean result = false;
        
        Connection connect = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM " + table + " WHERE login=? limit 1";
        try{
            
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1,login);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                result = true;
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
        
        return result;
    }
    
}
