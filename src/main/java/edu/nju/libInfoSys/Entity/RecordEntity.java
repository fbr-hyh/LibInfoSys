package edu.nju.libInfoSys.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Record", schema = "libinfo")
public class RecordEntity {
    private int recordId;
    private String bookId;
    private String userId;
    private Timestamp borrowTime;
    private Timestamp returnTime;
    private double overduePenalty;

    private int recordStatus;
//    借书未还：0
//    借书还了，但是欠费：1
//    借书还了不欠费 / 缴纳罚金了：2

    @Id
    @Column(name = "recordId")
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    @Basic
    @Column(name = "bookId")
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "borrowTime")
    public Timestamp getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Timestamp borrowTime) {
        this.borrowTime = borrowTime;
    }

    @Basic
    @Column(name = "returnTime")
    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    @Basic
    @Column(name = "overduePenalty")
    public double getOverduePenalty() {
        return overduePenalty;
    }

    public void setOverduePenalty(double overduePenalty) {
        this.overduePenalty = overduePenalty;
    }

    @Basic
    @Column(name = "recordStatus")
    public int getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(int recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecordEntity that = (RecordEntity) o;

        if (recordId != that.recordId) return false;
        if (Double.compare(that.overduePenalty, overduePenalty) != 0) return false;
        if (recordStatus != that.recordStatus) return false;
        if (bookId != null ? !bookId.equals(that.bookId) : that.bookId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (borrowTime != null ? !borrowTime.equals(that.borrowTime) : that.borrowTime != null) return false;
        if (returnTime != null ? !returnTime.equals(that.returnTime) : that.returnTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = recordId;
        result = 31 * result + (bookId != null ? bookId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (borrowTime != null ? borrowTime.hashCode() : 0);
        result = 31 * result + (returnTime != null ? returnTime.hashCode() : 0);
        temp = Double.doubleToLongBits(overduePenalty);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + recordStatus;
        return result;
    }

    public RecordEntity() {
    }

    public RecordEntity(int recordId, String bookId, String userId, Timestamp borrowTime, Timestamp returnTime, double overduePenalty, int recordStatus) {
        this.recordId = recordId;
        this.bookId = bookId;
        this.userId = userId;
        this.borrowTime = borrowTime;
        this.returnTime = returnTime;
        this.overduePenalty = overduePenalty;
        this.recordStatus = recordStatus;
    }
}
