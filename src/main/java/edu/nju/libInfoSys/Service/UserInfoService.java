package main.java.edu.nju.libInfoSys.Service;

import main.java.edu.nju.libInfoSys.Entity.BorrowRecord;
import main.java.edu.nju.libInfoSys.Entity.OverduePenaltyRecord;

import java.util.ArrayList;

public interface UserInfoService {

    ArrayList<BorrowRecord> getAllBorrowReport();
    ArrayList<OverduePenaltyRecord> getAllOverduePenalty();
    ArrayList<BorrowRecord> getBorrowReportByUserId(String userId);
    ArrayList<OverduePenaltyRecord> getOverduePenaltyReportByUserId(String userId);
    double getOverduePenaltyByUserId(String userId);

}
