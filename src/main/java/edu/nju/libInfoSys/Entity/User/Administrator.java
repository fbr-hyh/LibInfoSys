package edu.nju.libInfoSys.Entity.User;


import edu.nju.libInfoSys.Entity.BorrowRecord;
import edu.nju.libInfoSys.Entity.OverduePenaltyRecord;
import edu.nju.libInfoSys.Factory.ServiceFactory;
import edu.nju.libInfoSys.Service.BookOperationService;
import edu.nju.libInfoSys.Service.UserInfoService;
import edu.nju.libInfoSys.User;

import java.util.ArrayList;

public class Administrator extends UserEntity implements User {
    UserInfoService userInfoService = ServiceFactory.getUserInfoService();
    BookOperationService bookOperationService = ServiceFactory.getBookOperationService();

    public Administrator() {
    }

    public Administrator(String userId, String password) {
        super(userId, password, 4);
    }

    public void update(String message) {
        System.out.println("*用户信息更新：" + message);
    }

    public ArrayList<BorrowRecord> generateBorrowReport(String userId) {
        // TODO: 2019-01-26
        ArrayList<BorrowRecord> borrowReports=userInfoService.getBorrowReportByUserId(userId);
        System.out.println(userId+" 的借书清单============================");
        for (BorrowRecord borrowRecord : borrowReports) {
            System.out.println("recordId:"+borrowRecord.getRecordId()+" bookId:"+borrowRecord.getBookId()
                    +" userId:"+borrowRecord.getUserId()+" borrowTime:"+borrowRecord.getBorrowTime()+" returnTime:"+borrowRecord.getReturnTime()+" status:"+borrowRecord.getStatus());
        }
        return borrowReports;
    }

    public ArrayList<OverduePenaltyRecord> generateOverduePenaltyReport(String userId) {
        ArrayList<OverduePenaltyRecord> overduePenaltyReports = userInfoService.getOverduePenaltyReportByUserId(userId);
        System.out.println(userId+" 的超期清单============================");
        for (OverduePenaltyRecord overduePenaltyRecord : overduePenaltyReports) {
            System.out.println("recordId:"+overduePenaltyRecord.getRecordId()
                    +" bookId:"+overduePenaltyRecord.getBookId()
                    +" userId:"+overduePenaltyRecord.getUserId()
                    +" time:"+overduePenaltyRecord.getTimestamp()
                    +" overduePenalty:"+overduePenaltyRecord.getOverduePenalty());
        }
        return overduePenaltyReports;
    }

    public double generateOverduePenalty(String userId) {
        double price = userInfoService.getOverduePenaltyByUserId(userId);
        System.out.println(userId+" 未还款: "+price);
        return price;
    }

    public boolean editBookPrice(String bookId,double price) {
        return bookOperationService.editBookPrice(bookId, price);
    }


}