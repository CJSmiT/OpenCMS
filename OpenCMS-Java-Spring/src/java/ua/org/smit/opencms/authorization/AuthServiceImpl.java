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
public class AuthServiceImpl implements AuthService{

    @Override
    public UserAuth getUserBySession(String session) {
        UserAuth user = new UserAuth();
        user.setType(UserType.GUEST);
        return user;
    }

    @Override
    public boolean theUserIsset(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean thePasswordCorrect(String login, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String updateUserSession(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
