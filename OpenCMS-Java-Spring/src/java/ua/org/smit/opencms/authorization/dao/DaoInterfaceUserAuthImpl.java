/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.authorization.dao;

import ua.org.smit.opencms.authorization.UserAuth;

/**
 *
 * @author alex
 */
public class DaoInterfaceUserAuthImpl implements DaoInterfaceUserAuth {
    
    private DaoLayeUserAuth daoUserAuth = new DaoLayeUserAuth();

    @Override
    public UserAuthDto getUserBySession(String session) {
        return daoUserAuth.getUserBySession(session);
    }

    @Override
    public UserAuthDto getUserByLogin(String login) {
        return daoUserAuth.getUserByLogin(login);
    }

    @Override
    public void updateUser(UserAuthDto user) {
        daoUserAuth.updateUser(user);
    }

    @Override
    public boolean checkUserInDb(String login) {
        return daoUserAuth.checkUserInDb(login);
    }
    
    
}
