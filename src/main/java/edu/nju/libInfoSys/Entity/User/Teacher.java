package main.java.edu.nju.libInfoSys.Entity.User;

public class Teacher extends User implements main.java.edu.nju.libInfoSys.User {

    public Teacher() {
    }

    public Teacher(String userId, String password) {
        super(userId, password,1);
    }
}
