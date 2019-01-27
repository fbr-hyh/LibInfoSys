package edu.nju.libInfoSys.Service;


import edu.nju.libInfoSys.Dao.UserDao;
import edu.nju.libInfoSys.Dao.UserDaoImpl;
import edu.nju.libInfoSys.Entity.User.Administrator;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public ArrayList<Administrator> getAllAdministrator() {
        return userDao.getAllAdministrator();
    }
}
