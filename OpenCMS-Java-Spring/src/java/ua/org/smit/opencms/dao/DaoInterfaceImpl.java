/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smit
 */
public class DaoInterfaceImpl implements DaoInterface{

    private final DaoLayerMaterial daoMaterial = new DaoLayerMaterial();
    private final DaoLayerCategory daoCategory = new DaoLayerCategory();
    
    @Override
    public MaterialEntityCMS getMaterial(int id) {
       return daoMaterial.getMaterial(id);
      
    }

    @Override
    public int writeMaterial(MaterialEntityCMS material) {
        return daoMaterial.writeMaterial(material);
    }

    @Override
    public void updateMaterial(MaterialEntityCMS material) {
        daoMaterial.updateMaterial(material);
    }

    @Override
    public void deleteMaterial(MaterialEntityCMS material) {
        daoMaterial.deleteMaterial(material);
    }

    @Override
    public ArrayList<MaterialEntityCMS> getAllMaterials() {
        return daoMaterial.getAllMaterials();
    }

    @Override
    public ArrayList<MaterialEntityCMS> getLastMaterialsByLimit(int limit) {
        return daoMaterial.getLastMaterialsByLimit(limit);
    }

    @Override
    public int writeCategory(CategoryEntityCMS category) {
        return daoCategory.writeCategory(category);
    }

    @Override
    public CategoryEntityCMS getCategory(int id) {
       return daoCategory.getCategory(id);
    }

    @Override
    public void updateCategory(CategoryEntityCMS category) {
        daoCategory.updateCategory(category);
    }

    @Override
    public void deleteCategory(CategoryEntityCMS category) {
        daoCategory.deleteCategory(category);
    }

    @Override
    public ArrayList<CategoryEntityCMS> getAllCategoryes() {
        return daoCategory.getAllCategoryes();
    }
    
    

    @Override
    public ArrayList<MaterialEntityCMS> getMaterialsByCatAndLimit(int catID, int index, int limit) {
        return daoMaterial.getMaterialsByCatAndLimit(catID,index,limit);
    }

    @Override
    public ArrayList<MaterialEntityCMS> getPublicMaterialsByCatAndLimit(int categoryId, int indexStart, int limit) {
        return daoMaterial.getPublicMaterialsByCatAndLimit(categoryId,indexStart,limit);
    }

    @Override
    public MaterialEntityCMS getPublicMaterialByAlias(String alias) {
        return daoMaterial.getPublicMaterialByAlias(alias);
    }

    @Override
    public void clearDb() {
        daoMaterial.clear();
        daoCategory.clear();
    }

    @Override
    public ArrayList<MaterialEntityCMS> getLastPublicMaterialsByCatAndLimit(int categoryId, int limit) {
        return daoMaterial.getLastPublicMaterialsByCatAndLimit(categoryId, limit);
    }


    @Override
    public MaterialEntityCMS getMaterialByAlias(String alias) {
        return daoMaterial.getMaterialByAlias(alias);
    }

    @Override
    public ArrayList<MaterialEntityCMS> getMaterialsByCategory(int catID) {
        return daoMaterial.getMaterialsByCategory(catID);
    }

    
}
