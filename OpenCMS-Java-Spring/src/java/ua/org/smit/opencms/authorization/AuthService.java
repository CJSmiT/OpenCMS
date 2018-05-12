/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.authorization;

/**
 *
 * @author smit
 */
public interface AuthService {
    
    public UserAuth getUserBySession(String session);

    public boolean theUserIsset(String login);

    public boolean thePasswordCorrect(String login, String password);

    public String updateUserSession(String login);
    
    
}
