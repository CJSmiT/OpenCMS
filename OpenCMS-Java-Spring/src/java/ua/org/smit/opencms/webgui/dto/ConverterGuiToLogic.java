/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.webgui.dto;

import ua.org.smit.opencms.content.MaterialDto;

/**
 *
 * @author smit
 */
public class ConverterGuiToLogic {
    
    public MaterialDto convert(MaterialGUIDto guiDto){
        
        MaterialDto dto = new MaterialDto();
        
        dto.setId(guiDto.getId());
        dto.setTitle(guiDto.getTitle());
        dto.setTextBody(guiDto.getTextBody());
        dto.setAlias(guiDto.getAlias());
        dto.setCategoryId(guiDto.getCategoryId());
        dto.setIsPublicMaterial(guiDto.isIsPublic());
        
        return dto; 
    }
    
}
