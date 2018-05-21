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
public interface DaoInterfaceUserAuth {
    
    UserAuthDto getUserBySession(String session);

    UserAuthDto getUserByLogin(String login);

    void updateUser(UserAuthDto user);

    public boolean checkUserInDb(String login);
}
