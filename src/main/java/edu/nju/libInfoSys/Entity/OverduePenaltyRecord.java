package main.java.edu.nju.libInfoSys.Entity;

import java.sql.Timestamp;

public class OverduePenaltyRecord {
    int recordId;
    String userId;
    String bookId;
    Timestamp timestamp;//欠费时间 即return时间
    double overduePenalty;
    int recordStatus;

    public OverduePenaltyRecord(int recordId, String userId, String bookId, Timestamp timestamp, double overduePenalty, int recordStatus) {
        this.recordId = recordId;
        this.userId = userId;
        this.bookId = bookId;
        this.timestamp = timestamp;
        this.overduePenalty = overduePenalty;
        this.recordStatus = recordStatus;
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

    public int getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(int recordStatus) {
        this.recordStatus = recordStatus;
    }
}
