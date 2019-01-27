package edu.nju.libInfoSys.Entity;

import java.sql.Timestamp;

public class OverduePenaltyRecord {
    int recordId;
    String userId;
    String bookId;
    Timestamp timestamp;//欠费时间 即return时间
    double overduePenalty;

    public OverduePenaltyRecord(int recordId, String userId, String bookId, Timestamp timestamp, double overduePenalty) {
        this.recordId = recordId;
        this.userId = userId;
        this.bookId = bookId;
        this.timestamp = timestamp;
        this.overduePenalty = overduePenalty;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getOverduePenalty() {
        return overduePenalty;
    }

    public void setOverduePenalty(double overduePenalty) {
        this.overduePenalty = overduePenalty;
    }

}
