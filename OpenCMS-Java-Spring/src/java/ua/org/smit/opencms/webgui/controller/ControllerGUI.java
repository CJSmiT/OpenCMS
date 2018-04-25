/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.webgui.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.org.smit.opencms.dao.MaterialEntityCMS;
import ua.org.smit.opencms.webgui.dto.MaterialGUIDto;
import ua.org.smit.opencms.logic.LogicInterfaceImpl;
import ua.org.smit.opencms.logic.MaterialDto;
import ua.org.smit.opencms.logic.LogicInterface;


@Controller
public class ControllerGUI {
    
    private LogicInterface logic = new LogicInterfaceImpl();
    
    @RequestMapping(value= "/home")
    public ModelAndView getHome(){
        ModelAndView model = new ModelAndView("home");
        
        ArrayList<MaterialEntityCMS> materials = logic.getAll();
        
        model.addObject("materials", materials);
        model.addObject("categories", logic.getAllCategories());
        
        return model;
    }
    
    @RequestMapping(value= "/send_material")
    public Object makingNewMaterial(MaterialGUIDto material){
        
        MaterialDto dto = new MaterialDto();
        dto.setTitle(material.getTitle());
        dto.setTextBody(material.getTextBody());
        dto.setCategoryId(material.getCategoryId());
        
        if (logic.thisCategoryExist(dto.getCategoryId())){
            logic.makeMaterial(dto);
        } else {
            // err!
        }
        
        
        return "redirect:home";
    }
    
    
}
