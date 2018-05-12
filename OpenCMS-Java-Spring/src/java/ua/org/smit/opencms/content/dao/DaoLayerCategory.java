/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.content.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class DaoLayerCategory extends ConectMSQL{
     private final String table = "category";
    
    CategoryEntityCMS getCategory(int id){
        Connection connect = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM " + table + " WHERE id=? limit 1";
        CategoryEntityCMS category = null;
        try{
            
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                category = getByParser(resultSet);
            }
            
            
        }catch(SQLException ex){
            Logger.getLogger(DaoLayerCategory.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                preparedStatement.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayerCategory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(category != null){
            return category;
        } else {
            throw new RuntimeException("Err to get material by '" + id + "' !");
        }
        
    }

    int writeCategory(CategoryEntityCMS category) {
         
        Connection connect = getConnection();
        PreparedStatement ps = null;
        int id = 0;
        try {
            String query = "INSERT INTO `" + table + "` (`title`,`alias`)"
                    + "VALUES (?,?);"; 
            ps = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, category.getTitle());
            ps.setString(2, category.getAlias());
                        
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoLayerCategory.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayerCategory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (id == 0){
            throw new RuntimeException("Error cannot be '0' !");
        }else{
            return id;
        }
    }

    void updateCategory(CategoryEntityCMS category) {
        Connection connect = getConnection();
        PreparedStatement ps = null;
        try {                              
            String query = "UPDATE `" + table + "` SET title=?,alias=? "
                    + "WHERE id='"+ category.getId() + "' "
                    + "order by `id` desc limit 1";
            ps = connect.prepareStatement(query);
            ps.setString(1, category.getTitle());
            ps.setString(2, category.getAlias());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoLayerCategory.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayerCategory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void deleteCategory(CategoryEntityCMS category) {
        Connection connect = getConnection();
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM `" + table 
                    + "` where id="+ category.getId()
                    +" order by id desc limit 1;";
            ps = connect.prepareStatement(query);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoLayerCategory.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayerCategory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    ArrayList<CategoryEntityCMS> getAllCategoryes() {
        ArrayList<CategoryEntityCMS> category = new ArrayList();
        
        Connection connect = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM " + table;
        try{
            
            preparedStatement = connect.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                category.add(getByParser(resultSet));
            }
            
            
        }catch(SQLException ex){
            Logger.getLogger(DaoLayerCategory.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                preparedStatement.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayerCategory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return category;
    }

    private CategoryEntityCMS getByParser(ResultSet resultSet) {
        try {
            CategoryEntityCMS category = new CategoryEntityCMS();
            
            category.setId(resultSet.getInt("id"));
            category.setTitle(resultSet.getString("title"));
            category.setAlias(resultSet.getString("alias"));
            return category;
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoLayerCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new RuntimeException("Err to get material");
    }    

    void clear() {
         Connection connect = getConnection();
        PreparedStatement ps = null;
        try {
            String query = "TRUNCATE TABLE " + table;
            // delete from table where id=0;
            ps = connect.prepareStatement(query);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                ps.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}