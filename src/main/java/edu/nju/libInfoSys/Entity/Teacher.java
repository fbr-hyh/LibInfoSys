package edu.nju.libInfoSys.Entity;

public class Teacher extends User implements edu.nju.libInfoSys.User {

    public Teacher() {
    }

    public Teacher(String userId, String password) {
        super(userId, password);
    }
}
