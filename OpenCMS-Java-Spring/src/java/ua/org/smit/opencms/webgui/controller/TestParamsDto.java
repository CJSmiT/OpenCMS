/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.webgui.controller;

/**
 *
 * @author smit
 */
public class TestParamsDto {
    public String alias;
    public String alias2;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAlias2() {
        return alias2;
    }

    public void setAlias2(String alias2) {
        this.alias2 = alias2;
    }
    
    

    @Override
    public String toString() {
        return "TestParamsDto{" + "alias=" + alias + ", alias2=" + alias2 + '}';
    }
    
    
}
