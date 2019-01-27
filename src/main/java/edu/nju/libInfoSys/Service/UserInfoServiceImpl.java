package edu.nju.libInfoSys.Service;

import edu.nju.libInfoSys.Dao.UserInfoDao;
import edu.nju.libInfoSys.Dao.UserInfoDaoImpl;
import edu.nju.libInfoSys.Entity.BorrowRecord;
import edu.nju.libInfoSys.Entity.OverduePenaltyRecord;
import edu.nju.libInfoSys.Entity.Record;

import java.util.ArrayList;

public class UserInfoServiceImpl implements UserInfoService {
    UserInfoDao userInfoDao = new UserInfoDaoImpl();

//    @Override
//    public ArrayList<BorrowRecord> getAllBorrowReport() {
//        return null;
//    }
//
//    @Override
//    public ArrayList<OverduePenaltyRecord> getAllOverduePenalty() {
//        return null;
//    }

    @Override
    public ArrayList<BorrowRecord> getBorrowReportByUserId(String userId) {
        ArrayList<BorrowRecord> borrowRecords = new ArrayList<>();
        ArrayList<Record> records=userInfoDao.getReportsByUserId(userId);
        int i = 0;
        for (Record record : records) {
            borrowRecords.add(new BorrowRecord(i, record.getBookId(), record.getUserId(), record.getBorrowTime(), record.getReturnTime(),record.getRecordStatus()));
            i++;
        }
        return borrowRecords;
    }

    @Override
    public ArrayList<OverduePenaltyRecord> getOverduePenaltyReportByUserId(String userId) {
        ArrayList<OverduePenaltyRecord> overduePenaltyRecords = new ArrayList<>();
        ArrayList<Record> records = userInfoDao.getOverdueReportsByUserId(userId);
        int i = 0;
        for (Record record : records) {
            overduePenaltyRecords.add(new OverduePenaltyRecord(i,record.getUserId(),record.getBookId(),record.getReturnTime(),record.getOverduePenalty()));
            i++;
        }
        return overduePenaltyRecords;
    }

    @Override
    public double getOverduePenaltyByUserId(String userId) {
        return userInfoDao.getOverduePenaltyByUserId(userId);
    }
}
