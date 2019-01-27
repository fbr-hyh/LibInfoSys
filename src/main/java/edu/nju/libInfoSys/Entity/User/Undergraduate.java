package edu.nju.libInfoSys.Entity.User;

import edu.nju.libInfoSys.User;

public class Undergraduate extends UserEntity implements User {
    public Undergraduate() {
    }

    public Undergraduate(String userId, String password) {
        super(userId, password,2);
    }
}
