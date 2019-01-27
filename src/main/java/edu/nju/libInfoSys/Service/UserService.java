package edu.nju.libInfoSys.Service;

import edu.nju.libInfoSys.Entity.User.Administrator;
import edu.nju.libInfoSys.Entity.User.User;

import java.util.ArrayList;

public interface UserService {
    ArrayList<Administrator> getAllAdministrator();
}
