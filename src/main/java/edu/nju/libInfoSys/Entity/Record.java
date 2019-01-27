package edu.nju.libInfoSys.Entity;

import java.sql.Timestamp;

public class Record {
    int recordId;
    String bookId;
    String userId;
    Timestamp borrowTime;
    Timestamp returnTime;
    double overduePenalty;
    int recordStatus;
}
