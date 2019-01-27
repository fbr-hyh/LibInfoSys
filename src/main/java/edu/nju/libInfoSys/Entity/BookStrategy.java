package edu.nju.libInfoSys.Entity;

import java.util.ArrayList;

public class BookStrategy {
    private int strategyId;
    private String strategyName;
    private int maxBorrowNum;
    private int borrowPeriods;
    private ArrayList<String> blockedCategories;

    public BookStrategy() {
    }

    public BookStrategy(int strategyId, String strategyName, int maxBorrowNum, int borrowPeriods, ArrayList<String> blockedCategories) {
        this.strategyId = strategyId;
        this.strategyName = strategyName;
        this.maxBorrowNum = maxBorrowNum;
        this.borrowPeriods = borrowPeriods;
        this.blockedCategories = blockedCategories;
    }

    public boolean borrowBook(String userId,String bookId) {
        // TODO: 2019-01-26
        // 在blockedCategories表中的书不能借

        return true;
    }

    public double returnBook(String userId,String bookId) {
        // TODO: 2019-01-26
        // 0表示成功，正数表示逾期罚款？
        return 0;
    }

    public int getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(int strategyId) {
        this.strategyId = strategyId;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public int getMaxBorrowNum() {
        return maxBorrowNum;
    }

    public void setMaxBorrowNum(int maxBorrowNum) {
        this.maxBorrowNum = maxBorrowNum;
    }

    public int getBorrowPeriods() {
        return borrowPeriods;
    }

    public void setBorrowPeriods(int borrowPeriods) {
        this.borrowPeriods = borrowPeriods;
    }

    public ArrayList<String> getBlockedCategories() {
        return blockedCategories;
    }

    public void setBlockedCategories(ArrayList<String> blockedCategories) {
        this.blockedCategories = blockedCategories;
    }
}
