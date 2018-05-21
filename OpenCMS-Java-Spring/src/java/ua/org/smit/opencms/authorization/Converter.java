/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.authorization;

import ua.org.smit.opencms.authorization.dao.UserAuthDto;

/**
 *
 * @author smit
 */
public class Converter {
    
    public static UserAuth toEntity(UserAuthDto dto){
        UserAuth entity = new UserAuth();
        entity.setId(dto.getId());
        entity.setLogin(dto.getLogin());
        entity.setType(UserType.valueOf(dto.getType().toUpperCase()));
        entity.setSession(dto.getSession());
        entity.setPassword(dto.getPassword());
        entity.setGroups(ConverterByComa.stringToLis(dto.getGroups()));
        
        
        
        return entity;
    }
    
    public static UserAuthDto toDto(UserAuth entity){
        UserAuthDto entityDto = new UserAuthDto();
        entityDto.setId(entity.getId());
        entityDto.setLogin(entity.getLogin());
        entityDto.setType(entity.getType().toString().toUpperCase());
        entityDto.setSession(entity.getSession());
        entityDto.setPassword(entity.getPassword());
        entityDto.setGroups(ConverterByComa.listToString(entity.getGroups()));
        
        
        
        return entityDto;
    }
    
}
