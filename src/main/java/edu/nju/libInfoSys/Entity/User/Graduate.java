package edu.nju.libInfoSys.Entity.User;


import edu.nju.libInfoSys.User;

public class Graduate extends UserEntity implements User {
    public Graduate() {
    }

    public Graduate(String userId, String password) {
        super(userId, password,3);
    }
}
