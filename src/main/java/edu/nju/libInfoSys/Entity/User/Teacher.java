package edu.nju.libInfoSys.Entity.User;

import edu.nju.libInfoSys.User;

public class Teacher extends UserEntity implements User {

    public Teacher() {
    }

    public Teacher(String userId, String password) {
        super(userId, password,1);
    }
}
