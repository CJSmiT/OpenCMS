/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.authorization;

import java.util.ArrayList;

/**
 *
 * @author smit
 */
public class UserAuth {
    private int id;
    private String login;
    private UserType type;
    private String session;
    private String password;
    private ArrayList<String> groups;

    public ArrayList<String> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<String> groups) {
        this.groups = groups;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public boolean isGuest() {
        return this.type == UserType.GUEST;
    }

    public boolean isAdminGroup() {
        for (String group:groups){
            if (group.equalsIgnoreCase("admin")){
                return true;
            }
        }
        return false;
    }
    
    
}
