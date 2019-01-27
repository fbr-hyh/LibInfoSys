package edu.nju.libInfoSys.Service;

import edu.nju.libInfoSys.Dao.UserInfoDao;
import edu.nju.libInfoSys.Entity.BorrowRecord;
import edu.nju.libInfoSys.Entity.OverduePenaltyRecord;
import edu.nju.libInfoSys.Entity.RecordEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;

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
        ArrayList<RecordEntity> recordEntities = userInfoDao.getReportsByUserId(userId);
        int i = 0;
        for (RecordEntity recordEntity : recordEntities) {
            borrowRecords.add(new BorrowRecord(i, recordEntity.getBookId(), recordEntity.getUserId(), recordEntity.getBorrowTime(), recordEntity.getReturnTime(), recordEntity.getRecordStatus()));
            i++;
        }
        return borrowRecords;
    }

    @Override
    public ArrayList<OverduePenaltyRecord> getOverduePenaltyReportByUserId(String userId) {
        ArrayList<OverduePenaltyRecord> overduePenaltyRecords = new ArrayList<>();
        ArrayList<RecordEntity> recordEntities = userInfoDao.getOverdueReportsByUserId(userId);
        int i = 0;
        for (RecordEntity recordEntity : recordEntities) {
            overduePenaltyRecords.add(new OverduePenaltyRecord(i, recordEntity.getUserId(), recordEntity.getBookId(), recordEntity.getReturnTime(), recordEntity.getOverduePenalty()));
            i++;
        }
        return overduePenaltyRecords;
    }

    @Override
    public double getOverduePenaltyByUserId(String userId) {
        return userInfoDao.getOverduePenaltyByUserId(userId);
    }

    @Override
    public void modifyPassword(String userId, String newPassword) {
        userInfoDao.modifyPassword(userId, newPassword);
    }
}
