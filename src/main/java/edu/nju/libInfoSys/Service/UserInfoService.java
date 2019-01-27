package edu.nju.libInfoSys.Service;

import java.util.ArrayList;

public interface UserInfoService {

    ArrayList<String> getAllBorrowReport();
    ArrayList<String> getAllOverduePenalty();
    ArrayList<String> getBorrowReportByUserId(String userId);
    ArrayList<String> getOverduePenaltyReportByUserId(String userId);
    double getOverduePenaltyByUserId(String userId);

}
