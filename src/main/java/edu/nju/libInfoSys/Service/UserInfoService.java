package edu.nju.libInfoSys.Service;

import edu.nju.libInfoSys.Entity.BorrowRecord;
import edu.nju.libInfoSys.Entity.OverduePenaltyRecord;

import java.util.ArrayList;

public interface UserInfoService {

    ArrayList<BorrowRecord> getAllBorrowReport();
    ArrayList<OverduePenaltyRecord> getAllOverduePenalty();
    ArrayList<BorrowRecord> getBorrowReportByUserId(String userId);
    ArrayList<OverduePenaltyRecord> getOverduePenaltyReportByUserId(String userId);
    double getOverduePenaltyByUserId(String userId);

}
