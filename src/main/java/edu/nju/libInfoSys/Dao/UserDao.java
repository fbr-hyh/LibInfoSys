package edu.nju.libInfoSys.Dao;

import edu.nju.libInfoSys.Entity.User.Administrator;

import java.util.ArrayList;

public interface UserDao {
    ArrayList<Administrator> getAllAdministrator();
}
