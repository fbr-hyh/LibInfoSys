package edu.nju.libInfoSys.Entity.User;

public class Undergraduate extends UserEntity implements edu.nju.libInfoSys.User {
    public Undergraduate() {
    }

    public Undergraduate(String userId, String password) {
        super(userId, password,2);
    }
}
