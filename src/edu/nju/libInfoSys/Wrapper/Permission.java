package edu.nju.libInfoSys.Wrapper;

import edu.nju.libInfoSys.User;

import javax.persistence.Persistence;

public abstract class Permission {
    protected User user;

    public Permission(User user) {
        this.user = user;
    }
}
