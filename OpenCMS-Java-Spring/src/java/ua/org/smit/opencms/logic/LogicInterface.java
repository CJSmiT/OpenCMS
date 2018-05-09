/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.logic;

import java.io.File;
import java.util.ArrayList;
import ua.org.smit.opencms.dao.MaterialEntityCMS;

/**
 *
 * @author smit
 */
public interface LogicInterface {
  
    public int makeMaterial(MaterialDto dto);
    
    public MaterialEntityCMS getMaterialByID(int id);

    public ArrayList<MaterialEntityCMS> getLast30News();

    public void updateMaterial(MaterialDto dto);

    public void deleteByID(int materialId);

    public void addFileInMaterial(int materialId, String fileName, File file);

    public void deleteFileInMaterial(int materialId, String fileName);
    
    public ArrayList<MaterialEntityCMS> getMaterialsByCategory(int catID);

    public ArrayList<MaterialEntityCMS> getMaterialsByCatAndLimit(int catID, int index, int limit);

    public MaterialEntityCMS getPublicMaterialByAlias(String url);

    public ArrayList<MaterialEntityCMS> getPublicMaterialsByCatAndLimit(int id, int indexInt, int limit);
    
    public ArrayList<MaterialEntityCMS> getLastPublicMaterialsByCatAndLimit(int categoryId, int limit);

    public void deleteMaterialsByCategory(int id);

    public ArrayList<MaterialEntityCMS> getAll();
    
    public boolean thisCategoryExist(int categoryId);
    
    public boolean theMaterialExist(int materialId);

    public Object getAllCategories();

    public void makeThisMaterialAsPublic(String alias);

    public MaterialEntityCMS getMaterialByAlias(String alias);

    public void makeThisMaterialAsNoPublic(String alias);
    
    public void changePublicStatusMaterial(String alias);
}
