package edu.nju.libInfoSys.Entity;

import java.util.ArrayList;

public class Administrator extends User implements edu.nju.libInfoSys.User {

    public void update(String message) {
        System.out.println("*用户信息更新：" + message);
    }

    public ArrayList<String> generateBorrowReport(String userId) {
        // TODO: 2019-01-26
        return null;
    }

    public double generateOverduePenalty(String userId) {
        // TODO: 2019-01-26
        return 0;
    }

}