package edu.nju.libInfoSys.Entity.User;


public class Graduate extends UserEntity implements edu.nju.libInfoSys.User {
    public Graduate() {
    }

    public Graduate(String userId, String password) {
        super(userId, password,3);
    }
}
