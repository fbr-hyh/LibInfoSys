package edu.nju.libInfoSys.Entity.Generated;

import javax.persistence.*;

@Entity
@Table(name = "BookStrategy", schema = "libinfo")
public class BookStrategyEntity {
    private int strategyId;
    private String strategyName;
    private int maxBorrowNum;
    private int borrowPeriods;
    private String blockedCategories;

    @Id
    @Column(name = "strategyId")
    public int getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(int strategyId) {
        this.strategyId = strategyId;
    }

    @Basic
    @Column(name = "strategyName")
    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    @Basic
    @Column(name = "maxBorrowNum")
    public int getMaxBorrowNum() {
        return maxBorrowNum;
    }

    public void setMaxBorrowNum(int maxBorrowNum) {
        this.maxBorrowNum = maxBorrowNum;
    }

    @Basic
    @Column(name = "borrowPeriods")
    public int getBorrowPeriods() {
        return borrowPeriods;
    }

    public void setBorrowPeriods(int borrowPeriods) {
        this.borrowPeriods = borrowPeriods;
    }

    @Basic
    @Column(name = "blockedCategories")
    public String getBlockedCategories() {
        return blockedCategories;
    }

    public void setBlockedCategories(String blockedCategories) {
        this.blockedCategories = blockedCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookStrategyEntity that = (BookStrategyEntity) o;

        if (strategyId != that.strategyId) return false;
        if (maxBorrowNum != that.maxBorrowNum) return false;
        if (borrowPeriods != that.borrowPeriods) return false;
        if (strategyName != null ? !strategyName.equals(that.strategyName) : that.strategyName != null) return false;
        if (blockedCategories != null ? !blockedCategories.equals(that.blockedCategories) : that.blockedCategories != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = strategyId;
        result = 31 * result + (strategyName != null ? strategyName.hashCode() : 0);
        result = 31 * result + maxBorrowNum;
        result = 31 * result + borrowPeriods;
        result = 31 * result + (blockedCategories != null ? blockedCategories.hashCode() : 0);
        return result;
    }
}
