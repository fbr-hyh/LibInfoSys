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

    public Record(int recordId, String bookId, String userId, Timestamp borrowTime, Timestamp returnTime, double overduePenalty, int recordStatus) {
        this.recordId = recordId;
        this.bookId = bookId;
        this.userId = userId;
        this.borrowTime = borrowTime;
        this.returnTime = returnTime;
        this.overduePenalty = overduePenalty;
        this.recordStatus = recordStatus;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Timestamp getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Timestamp borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
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
