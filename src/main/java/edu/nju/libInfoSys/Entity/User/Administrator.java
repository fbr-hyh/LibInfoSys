package edu.nju.libInfoSys.Entity.User;

import edu.nju.libInfoSys.Service.UserInfoService;
import edu.nju.libInfoSys.Service.UserInfoServiceImpl;

import java.util.ArrayList;

public class Administrator extends User implements edu.nju.libInfoSys.User {

    UserInfoService userInfoService = new UserInfoServiceImpl();

    public Administrator() {
    }

    public Administrator(String userId, String password) {
        super(userId, password, 4);
    }

    public void update(String message) {
        System.out.println("*用户信息更新：" + message);
    }

    public ArrayList<String> generateBorrowReport(String userId) {
        // TODO: 2019-01-26
        ArrayList<String> borrowReports=userInfoService.getBorrowReportByUserId(userId);
        System.out.println(userId+" 的借书清单============================");
        for (String str : borrowReports) {
            System.out.println(str);
        }
        return borrowReports;
    }

    public ArrayList<String> generateOverduePenaltyReport(String userId) {
        ArrayList<String> overduePenaltyReports = userInfoService.getOverduePenaltyReportByUserId(userId);
        System.out.println(userId+" 的超期清单============================");
        for (String str : overduePenaltyReports) {
            System.out.println(str);
        }
        return overduePenaltyReports;
    }

    public double generateOverduePenalty(String userId) {
        // TODO: 2019-01-26
        double price = userInfoService.getOverduePenaltyByUserId(userId);
        System.out.println(userId+" 未还款: "+price);
        return price;
    }

}