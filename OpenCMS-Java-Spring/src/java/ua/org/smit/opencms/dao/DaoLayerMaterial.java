/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.dao;

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
 * @author smit
 */
class DaoLayerMaterial extends ConectMSQL{
    private final String table = "material";
    
    MaterialEntityCMS getMaterial(int id){
        Connection connect = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM " + table + " WHERE id=? limit 1";
        MaterialEntityCMS material = null;
        try{
            
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                material = getByParser(resultSet);
            }
            
            
        }catch(SQLException ex){
            Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                preparedStatement.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(material != null){
            return material;
        }else
        {
            throw new RuntimeException("Err to get material by '" + id + "' !");
        }
    }

    int writeMaterial(MaterialEntityCMS material) {
                int id = 0;
        Connection connect = getConnection();
        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO `" + table + "` (`title`,`textBody`,"
                    + "`alias`,`categoryId`,`userCreaterId`,`hits`,`isPublic`,"
                    + "`lockerUserId`,`realTimePublic`,`timePublic`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?);"; //INSERT INTO `material`(`title`) VALUES ('[value-2]');
            ps = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, material.getTitle());
            ps.setString(2, material.getTextBody());
            ps.setString(3, material.getAlias());
            ps.setInt(4, material.getCategoryId());
            ps.setInt(5, material.getUserCreaterId());
            ps.setInt(6, material.getHits());
            ps.setBoolean(7, material.isIsPublic());
            ps.setInt(8, material.getLockerUserId());
            ps.setTimestamp(9, material.getRealTimePublic());
            ps.setTimestamp(10, material.getTimePublic());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            
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
        
        if (id==0){
            throw new RuntimeException("Error cannot be '0' !");
        }
        return id;
        
    }

    void updateMaterial(MaterialEntityCMS material) {
        Connection connect = getConnection();
        PreparedStatement ps = null;
        try {
            String query = "UPDATE `" + table + "` "
                    + "SET title=?,"
                    + "textBody=?,"
                    + "alias=?,"
                    + "categoryId =?,"
                    + "userCreaterId =?,"
                    + "hits =?,"
                    + "isPublic =?,"
                    + "lockerUserId =?,"
                    + "realTimePublic =?,"
                    + "timePublic =?"
                    + "WHERE id='"+material.getId()+"' "
                    + "limit 1";
            ps = connect.prepareStatement(query);
            ps.setString(1, material.getTitle());
            ps.setString(2, material.getTextBody());
            ps.setString(3, material.getAlias());
            ps.setInt(4, material.getCategoryId());
            ps.setInt(5, material.getUserCreaterId());
            ps.setInt(6, material.getHits()); //???
            ps.setBoolean(7, material.isIsPublic());
            ps.setInt(8, material.getLockerUserId()); //???
            ps.setTimestamp(9, material.getRealTimePublic());//???
            ps.setTimestamp(10, material.getTimePublic());
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

    void deleteMaterial(MaterialEntityCMS material) {
        Connection connect = getConnection();
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM `" + table + "` where id="+ material.getId()+" limit 1;";
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

    ArrayList<MaterialEntityCMS> getAllMaterials() {
        ArrayList<MaterialEntityCMS> materials = new ArrayList();
        Connection connect = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM " + table;
        MaterialEntityCMS material = null;
        try{
            
            preparedStatement = connect.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                materials.add(getByParser(resultSet));
            }
            
            
        }catch(SQLException ex){
            Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                preparedStatement.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return materials;
    }

    private MaterialEntityCMS getByParser(ResultSet resultSet) {
        try {
            MaterialEntityCMS material = new MaterialEntityCMS();
            
            material.setId(resultSet.getInt("id"));
            material.setTitle(resultSet.getString("title"));
            material.setTextBody(resultSet.getString("textBody"));
            material.setAlias(resultSet.getString("alias"));
            material.setCategoryId(resultSet.getInt("categoryId"));
            material.setUserCreaterId(resultSet.getInt("userCreaterId"));
            material.setHits(resultSet.getInt("hits"));
            material.setIsPublic(resultSet.getBoolean("isPublic"));
            material.setLockerUserId(resultSet.getInt("lockerUserId"));
            material.setRealTimePublic(resultSet.getTimestamp("realTimePublic"));
            material.setTimePublic(resultSet.getTimestamp("timePublic"));
            return material;
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new RuntimeException("Err to get material");
    }

    ArrayList<MaterialEntityCMS> getLastMaterialsByLimit(int limit) {
        ArrayList<MaterialEntityCMS> materials = new ArrayList();
        Connection connect = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM " + table + " order by `id` desc limit " + limit;
        MaterialEntityCMS material = null;
        try{
            
            preparedStatement = connect.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                materials.add(getByParser(resultSet));
            }
            
            
        }catch(SQLException ex){
            Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                preparedStatement.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return materials;
    }

    ArrayList<MaterialEntityCMS> getMaterialsByCatAndLimit(int catID, int index, int limit) {
        ArrayList<MaterialEntityCMS> materials = new ArrayList();
        
        Connection connect = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM " + table + " WHERE `categoryId` = '" + catID + "' limit " + index + "," + limit;
        MaterialEntityCMS material = null;
        try{
            
            preparedStatement = connect.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                materials.add(getByParser(resultSet));
            }
            
            
        }catch(SQLException ex){
            Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                preparedStatement.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return materials;
    }

    ArrayList<MaterialEntityCMS> getPublicMaterialsByCatAndLimit(int categoryId, int indexStart, int limit) {
        ArrayList<MaterialEntityCMS> materials = new ArrayList();
        
        Connection connect = getConnection();
        PreparedStatement ps = null;
        String sql = "SELECT * FROM " + table + " "
                + "WHERE categoryId = "+ categoryId+ " "
                + "AND isPublic = ? "
                + "limit "+ indexStart + "," + limit;
        
        try{
            
            ps = connect.prepareStatement(sql);
            ps.setBoolean(1, true);
            
            ResultSet resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                materials.add(getByParser(resultSet));
            }
            
            
        }catch(SQLException ex){
            Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ps.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return materials;
    }

    MaterialEntityCMS getPublicMaterialByAlias(String alias) {
        Connection connect = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM " + table + " "
                + "WHERE `alias` = '"+ alias
                + "' AND `isPublic` = '1' "
                + "limit 1";
        MaterialEntityCMS material = null;
        try{
            
            preparedStatement = connect.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                material = getByParser(resultSet);
            }
            
            
        }catch(SQLException ex){
            Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                preparedStatement.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(material == null){
            throw new RuntimeException("material is null");
        }else {
            return material;
        }
        
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
    
    ArrayList<MaterialEntityCMS> getLastPublicMaterialsByCatAndLimit(int categoryId, int limit) {
        ArrayList<MaterialEntityCMS> materials = new ArrayList();
        
        Connection connect = getConnection();
        PreparedStatement ps = null;
        String sql = "SELECT * FROM " + table + " "
                + "WHERE categoryId = "+ categoryId+ " "
                + "AND isPublic = ? "
                + "order by id desc "
                + "limit "+ limit ;
        
        try{
            
            ps = connect.prepareStatement(sql);
            ps.setBoolean(1, true);
            
            ResultSet resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                materials.add(getByParser(resultSet));
            }
            
            
        }catch(SQLException ex){
            Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ps.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return materials;
    }

    MaterialEntityCMS getMaterialByAlias(String alias) {
        Connection connect = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM " + table + " "
                + "WHERE alias = '"+ alias + "' "
                + "limit 1";
        MaterialEntityCMS material = null;
        try{
            
            preparedStatement = connect.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                material = getByParser(resultSet);
            }
            
            
        }catch(SQLException ex){
            Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                preparedStatement.close();
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayerMaterial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(material == null){
            throw new RuntimeException("material is null..........");
        }else {
            return material;
        }
    }


    
}
