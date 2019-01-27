package edu.nju.libInfoSys.Entity.User;

public class Teacher extends UserEntity implements edu.nju.libInfoSys.User {

    public Teacher() {
    }

    public Teacher(String userId, String password) {
        super(userId, password,1);
    }
}
