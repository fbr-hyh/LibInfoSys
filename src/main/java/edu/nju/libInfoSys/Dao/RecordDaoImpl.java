package edu.nju.libInfoSys.Dao;

import edu.nju.libInfoSys.Entity.RecordEntity;

import java.sql.Timestamp;

public class RecordDaoImpl implements RecordDao {
    @Override
    public boolean add(String bookId, String userId, Timestamp borrowTime) {
        return false;
    }

    @Override
    public RecordEntity getNotReturnRecord(String bookId, String userId) { //status=0
        return null;
    }

    @Override
    public boolean setReturnedOverdueAndStatus(int recordId, Timestamp returnTime, double overduePen, int status) {
        return false;
    }

    @Override
    public boolean setOverdue(String recordId, double overdue) {
        return false;
    }

    @Override
    public int getBorrowingNumByUserId(String userId) {
        return 0;
    }
}
