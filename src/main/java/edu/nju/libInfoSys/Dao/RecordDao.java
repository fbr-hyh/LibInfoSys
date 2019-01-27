package edu.nju.libInfoSys.Dao;

import edu.nju.libInfoSys.Entity.Record;

import java.sql.Timestamp;

public interface RecordDao {
    boolean add(String bookId, String userId, Timestamp borrowTime);

    Record getNotReturnRecord(String bookId, String userId); //其中status应是0

    boolean setReturnedOverdueAndStatus(int recordId,Timestamp returnTime,double overduePen,int status);

    boolean setOverdue(String recordId,double overdue);

    int getBorrowingNumByUserId(String userId);
}
