/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.opencms.authorization;
import java.util.UUID;
import ua.org.smit.opencms.authorization.dao.DaoInterfaceUserAuth;
import ua.org.smit.opencms.authorization.dao.DaoInterfaceUserAuthImpl;
import static ua.org.smit.opencms.webgui.utils.Md5.getHash;


/**
 *
 * @author smit
 */
public class AuthServiceImpl implements AuthService{
    
    private DaoInterfaceUserAuth dao = new DaoInterfaceUserAuthImpl();

    @Override
    public UserAuth getUserBySession(String session) {
        if(session == null){
            UserAuth user = new UserAuth();
            user.setType(UserType.GUEST);
            return user;
        }
        return dao.getUserBySession(session);
    }

    @Override
    public boolean theUserIsset(String login) {
        return dao.checkUserInDb(login);
    }

    @Override
    public boolean thePasswordCorrect(String login, String password) {
        System.out.println("+++ " + login);
        UserAuth user = dao.getUserByLogin(login);
        if(user.getPassword().equals(getHash(password))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String updateUserSession(String login) {
        String session = UUID.randomUUID().toString();
        
        UserAuth user = dao.getUserByLogin(login);
        user.setSession(session);
        dao.updateUser(user);
        return user.getSession();
    }

    
}
