package edu.nju.libInfoSys.Service;


import edu.nju.libInfoSys.Dao.UserDao;
import edu.nju.libInfoSys.Dao.UserDaoImpl;
import edu.nju.libInfoSys.Entity.User.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public ArrayList<Administrator> getAllAdministrator() {
        return userDao.getAllAdministrator();
    }
}
