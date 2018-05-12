/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.content;

import java.io.File;
import java.util.ArrayList;
import ua.org.smit.opencms.content.dao.CategoryEntityCMS;
import ua.org.smit.opencms.content.dao.DaoInterface;
import ua.org.smit.opencms.content.dao.DaoInterfaceImpl;
import ua.org.smit.opencms.content.dao.MaterialEntityCMS;

/**
 *
 * @author smit
 */
public class LogicInterfaceImpl implements LogicInterface {

    DaoInterface dao = new DaoInterfaceImpl();
    
    @Override
    public int makeMaterial(MaterialDto dto) {   
        //перед созданием материала проверить, существует ли такая категория.
        
        if (thisCategoryExist(dto.getCategoryId())){
        
        MaterialEntityCMS material = MaterialConverter.dtoToEntity(dto);
        material.makeAlias();
        material.makeCurrentTimePublic();
        return dao.writeMaterial(material);
        } else {
            throw new RuntimeException("'is no CategoryId '");
        }
    }

    @Override
    public MaterialEntityCMS getMaterialByID(int id) {
        if(theMaterialExist(id)){
            return dao.getMaterial(id);
        }
        throw new RuntimeException("'is no id material'");
    }

    @Override
    public ArrayList<MaterialEntityCMS> getLast30News() {
        return dao.getLastMaterialsByLimit(30);
    }

    @Override
    public void updateMaterial(MaterialDto dto) {
        
        MaterialEntityCMS material = getMaterialByID(dto.getId());
        material.setTitle(dto.getTitle());
        material.setTextBody(dto.getBody());
        material.setCategoryId(dto.getCategoryId());
        material.setIsPublic(dto.isPublicMaterial());
        material.setLockerUserId(dto.getLockerUserId());
        material.setRealTimePublic(dto.getRealTimePublic());
        
        dao.updateMaterial(material);
    }

    @Override
    public void deleteByID(int materialId) {
        if (theMaterialExist(materialId)){
            dao.deleteMaterial(getMaterialByID(materialId));
        }else 
           throw new RuntimeException("'is no id material'");
    }

    @Override
    public void addFileInMaterial(int materialId, String fileName, File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteFileInMaterial(int materialId, String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public ArrayList<MaterialEntityCMS> getMaterialsByCatAndLimit(int catID, int index, int limit) {
        return dao.getMaterialsByCatAndLimit(catID,index,limit);//1
    }

    @Override
    public MaterialEntityCMS getPublicMaterialByAlias(String alias) {
        return dao.getPublicMaterialByAlias(alias);//3
    }

    @Override
    public ArrayList<MaterialEntityCMS> getPublicMaterialsByCatAndLimit(int categoryId, int indexStart, int limit) {
        return dao.getPublicMaterialsByCatAndLimit(categoryId,indexStart,limit);//2
    }

    @Override
    public void deleteMaterialsByCategory(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<MaterialEntityCMS> getAll() {
        return dao.getAllMaterials();
    }

    @Override
    public boolean thisCategoryExist(int categoryId) {
        ArrayList<CategoryEntityCMS> categoryes = dao.getAllCategoryes();
        for(CategoryEntityCMS category : categoryes){
            if(category.getId() == categoryId){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean theMaterialExist(int materialId) {
        ArrayList<MaterialEntityCMS> materiales = dao.getAllMaterials();
        for(MaterialEntityCMS material : materiales){
            if(material.getId() == materialId){
                return true;
            }
        }
        return false;
    } 

    @Override
    public ArrayList<CategoryEntityCMS> getAllCategories() {
        return dao.getAllCategoryes();
    }

    @Override
    public ArrayList<MaterialEntityCMS> getLastPublicMaterialsByCatAndLimit(int categoryId, int limit) {
        return dao.getLastPublicMaterialsByCatAndLimit(categoryId, limit);
    }

    @Override
    public void makeThisMaterialAsPublic(String alias) {
        MaterialEntityCMS material = dao.getMaterialByAlias(alias);
        material.setIsPublic(true);
        dao.updateMaterial(material);
    }

    @Override
    public MaterialEntityCMS getMaterialByAlias(String alias) {
        return dao.getMaterialByAlias(alias);
    }

    @Override
    public void makeThisMaterialAsNoPublic(String alias) {
        MaterialEntityCMS material = dao.getMaterialByAlias(alias);
        material.setIsPublic(false);
        dao.updateMaterial(material);
    }

    @Override
    public void changePublicStatusMaterial(String alias) {
        MaterialEntityCMS material = dao.getMaterialByAlias(alias);
        
        if(material.isIsPublic() == true){
            material.setIsPublic(false);
        }else {
            material.setIsPublic(true);
        }
        
        dao.updateMaterial(material);
    }

    @Override
    public ArrayList<MaterialEntityCMS> getMaterialsByCategory(int catID) {
        return dao.getMaterialsByCategory(catID);
    }
}
