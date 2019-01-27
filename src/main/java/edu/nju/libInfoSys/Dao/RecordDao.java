package edu.nju.libInfoSys.Dao;

import java.sql.Timestamp;

public interface RecordDao {
    boolean add(String bookId, String userId, Timestamp borrowTime);
}
