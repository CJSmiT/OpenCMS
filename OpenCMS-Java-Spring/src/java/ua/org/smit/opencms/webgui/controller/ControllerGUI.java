/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.webgui.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        
        ArrayList<MaterialEntityCMS> materialsCat1 = logic.getLastPublicMaterialsByCatAndLimit(1, 5);
        ArrayList<MaterialEntityCMS> materialsCat2 = logic.getLastPublicMaterialsByCatAndLimit(2, 5);
        ArrayList<MaterialEntityCMS> materialsCat3 = logic.getLastPublicMaterialsByCatAndLimit(3, 5);
        
        model.addObject("materialsCat1", materialsCat1);
        model.addObject("materialsCat2", materialsCat2);
        model.addObject("materialsCat3", materialsCat3);
        
        return model;
    }
    
    @RequestMapping(value= "/create_material")
    public ModelAndView createMaterial(){
        ModelAndView model = new ModelAndView("Create material");
        model.addObject("categories", logic.getAllCategories());
        return model;
    }
    @RequestMapping(value = "/categories")
    public ModelAndView categories(){
        ModelAndView model = new ModelAndView("categories");
        model.addObject("categories", logic.getAllCategories());
        return model;
    }
    
    @RequestMapping(value= "/send_material")
    public Object makingNewMaterial(MaterialGUIDto material){
        
        MaterialDto dto = new MaterialDto();
        dto.setTitle(material.getTitle());
        dto.setTextBody(material.getTextBody());
        dto.setCategoryId(material.getCategoryId());
        dto.setIsPublic(material.isIsPublic());
        
        if (logic.thisCategoryExist(dto.getCategoryId())){
            logic.makeMaterial(dto);
        } else {
            // err!
        }

        return "redirect:home";
    }
    
    @RequestMapping(value= "/show_material")
    public ModelAndView showMaterial(
            @RequestParam(value = "alias") String alias){
        
        ModelAndView model = new ModelAndView("materialView");
        MaterialEntityCMS material = logic.getMaterialByAlias(alias);
        model.addObject("material", material);

        return model;
    }
    
    @RequestMapping(value= "/all_materials")
    public ModelAndView getAllmaterials(){
        ModelAndView model = new ModelAndView("all_materials");
        ArrayList<MaterialEntityCMS> all_materials = logic.getAll();
        model.addObject("all_materials", all_materials);    
        
        return model;
    }
    
    
    @RequestMapping(value= "/set_material_public")
    public Object PublicMaterial(@RequestParam(value = "alias") String alias){

       logic.makeThisMaterialAsPublic(alias);

        return "redirect:show_material?alias=" + alias;
    }
    
    @RequestMapping(value= "/set_material_no_public")
    public Object NoPublicMaterial(@RequestParam(value = "alias") String alias){

       logic.makeThisMaterialAsNoPublic(alias);

        return "redirect:show_material?alias=" + alias;
    }
    
}
