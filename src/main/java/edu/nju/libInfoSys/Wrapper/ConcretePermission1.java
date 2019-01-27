package main.java.edu.nju.libInfoSys.Wrapper;

import main.java.edu.nju.libInfoSys.User;
import main.java.edu.nju.libInfoSys.Entity.User.Administrator;

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
