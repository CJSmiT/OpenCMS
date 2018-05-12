/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.content.dao;

import ua.org.smit.opencms.content.AliasMaker;

/**
 *
 * @author alex
 */
public class CategoryEntityCMS {
    int id;
    String title;
    String alias;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    public void makeAlias() {
        this.alias = AliasMaker.generatorAlies(title);
    }
    
}
