package edu.nju.libInfoSys.Service;

import edu.nju.libInfoSys.Entity.BorrowRecord;
import edu.nju.libInfoSys.Entity.OverduePenaltyRecord;

import java.util.ArrayList;

public class UserInfoServiceImpl implements UserInfoService {
    @Override
    public ArrayList<BorrowRecord> getAllBorrowReport() {
        return null;
    }

    @Override
    public ArrayList<OverduePenaltyRecord> getAllOverduePenalty() {
        return null;
    }

    @Override
    public ArrayList<BorrowRecord> getBorrowReportByUserId(String userId) {
        return null;
    }

    @Override
    public ArrayList<OverduePenaltyRecord> getOverduePenaltyReportByUserId(String userId) {
        return null;
    }

    @Override
    public double getOverduePenaltyByUserId(String userId) {
        return 0;
    }
}
