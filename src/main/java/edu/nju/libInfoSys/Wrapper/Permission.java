package main.java.edu.nju.libInfoSys.Wrapper;

import main.java.edu.nju.libInfoSys.User;

public abstract class Permission {
    protected User user;

    public Permission(User user) {
        this.user = user;
    }
}
