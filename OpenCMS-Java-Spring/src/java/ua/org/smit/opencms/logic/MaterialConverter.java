/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.logic;

import ua.org.smit.opencms.dao.CategoryEntityCMS;
import ua.org.smit.opencms.dao.MaterialEntityCMS;

/**
 *
 * @author alex
 */
public class MaterialConverter {
    
    public static MaterialEntityCMS dtoToEntity(MaterialDto dto){
        
        MaterialEntityCMS material = new MaterialEntityCMS();
        
        material.setId(dto.getId());
        material.setTitle(dto.getTitle());
        material.setTextBody(dto.getBody());
        material.setCategoryId(dto.getCategoryId());
        material.setUserCreaterId(dto.getUserCreaterId());
        material.setHits(dto.getHits());
        material.setIsPublic(dto.isIsPublic());
        material.setLockerUserId(dto.getLockerUserId());
        material.setRealTimePublic(dto.getRealTimePublic());
        material.setTimePublic(dto.getTimePublic());
        return material;
    }
    
    public static MaterialDto entityToDto(MaterialEntityCMS material){
        
        MaterialDto dto = new MaterialDto();
        dto.setId(material.getId());
        dto.setTitle(material.getTitle());
        dto.setTextBody(material.getTextBody());
        dto.setCategoryId(material.getCategoryId());
        dto.setUserCreaterId(material.getUserCreaterId());
        dto.setHits(material.getHits());
        dto.setIsPublic(material.isIsPublic());
        dto.setLockerUserId(material.getLockerUserId());
        dto.setRealTimePublic(material.getRealTimePublic());
        dto.setTimePublic(material.getTimePublic());
        return dto;
    }
    
    public static CategoryDto categoryEntityToDto(CategoryEntityCMS category){
       CategoryDto dto = new CategoryDto();
       dto.setTitle(category.getTitle());
       dto.setAlias(category.getAlias());
       dto.setId(category.getId());
       return dto; 
    }
    
    public static CategoryEntityCMS categoryDtoToEntity (CategoryDto dto){
        CategoryEntityCMS entity = new CategoryEntityCMS();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setAlias(dto.getAlias());
        return entity;
    }
}

