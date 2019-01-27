package edu.nju.libInfoSys.Entity;

import java.sql.Timestamp;

public class BorrowRecord {
    int recordId;
    String bookId;
    String userId;
    Timestamp borrowTime;
    Timestamp returnTime;

    public BorrowRecord(int recordId, String bookId, String userId, Timestamp borrowTime, Timestamp returnTime) {
        this.recordId = recordId;
        this.bookId = bookId;
        this.userId = userId;
        this.borrowTime = borrowTime;
        this.returnTime = returnTime;
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
}
