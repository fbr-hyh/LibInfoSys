package edu.nju.libInfoSys.Entity.User;

import edu.nju.libInfoSys.Entity.User.User;

public class Teacher extends User implements edu.nju.libInfoSys.User {

    public Teacher() {
    }

    public Teacher(String userId, String password) {
        super(userId, password,1);
    }
}
