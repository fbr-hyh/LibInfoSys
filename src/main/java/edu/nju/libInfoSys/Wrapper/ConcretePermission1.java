package edu.nju.libInfoSys.Wrapper;

import edu.nju.libInfoSys.User;
import edu.nju.libInfoSys.Entity.User.Administrator;

import java.util.ArrayList;

public class ConcretePermission1 extends Permission {
    private Administrator administrator = new Administrator();
    public ConcretePermission1(User user) {
        super(user);
    }

    public ArrayList<String> generateBorrowReport(String userId) {
        return administrator.generateBorrowReport(userId);
    }
    public ArrayList<String> generateOverduePenaltyReport(String userId) {
        return administrator.generateOverduePenaltyReport(userId);
    }
    public double generateOverduePenalty(String userId) {
        return administrator.generateOverduePenalty(userId);
    }
}
