/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.content.dao;

import java.util.ArrayList;

/**
 *
 * @author smit
 */
public interface DaoInterface {
    
    int writeMaterial(MaterialEntityCMS material);
    
    MaterialEntityCMS getMaterial(int id);
    
    void updateMaterial(MaterialEntityCMS material);
    
    void deleteMaterial(MaterialEntityCMS material);
    
    ArrayList<MaterialEntityCMS> getAllMaterials();
    
    ArrayList<MaterialEntityCMS> getLastMaterialsByLimit(int limit);
    
        
    int writeCategory(CategoryEntityCMS category);
    
    CategoryEntityCMS getCategory(int id);
    
    void updateCategory(CategoryEntityCMS category);
    
    void deleteCategory(CategoryEntityCMS category);
    
    ArrayList<CategoryEntityCMS> getAllCategoryes();
    
    ArrayList<MaterialEntityCMS> getMaterialsByCategory(int catID);

    public ArrayList<MaterialEntityCMS> getMaterialsByCatAndLimit(int catID, int index, int limit);

    public ArrayList<MaterialEntityCMS> getPublicMaterialsByCatAndLimit(int categoryId, int indexStart, int limit);
    
    public ArrayList<MaterialEntityCMS> getLastPublicMaterialsByCatAndLimit(int categoryId, int limit);

    public MaterialEntityCMS getPublicMaterialByAlias(String alias);

    public void clearDb();


    public MaterialEntityCMS getMaterialByAlias(String alias);

    
    
      
}
