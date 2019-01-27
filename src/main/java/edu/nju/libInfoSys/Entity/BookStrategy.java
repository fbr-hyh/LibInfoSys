package edu.nju.libInfoSys.Entity;

import edu.nju.libInfoSys.Service.BookOprationService;
import edu.nju.libInfoSys.Service.BookOprationServiceImpl;
import edu.nju.libInfoSys.Service.RecordService;
import edu.nju.libInfoSys.Service.RecordServiceImpl;

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
        BookOprationService bookOprationService = new BookOprationServiceImpl();
        RecordService recordService = new RecordServiceImpl();

        //可能已被借走
        if (bookOprationService.getBookStatus(bookId) == 0) {
            System.out.println("该图书已被借走");
            return false;
        }
        // 在blockedCategories表中的书不能借
        String catagory = bookId.substring(0, 1);
        if (blockedCategories.contains(catagory)) {
            System.out.println("该用户不允许借阅该类图书: " + catagory);
            return false;
        } else {
            //借阅图书 图书status:=1
            bookOprationService.borrowBook(bookId);
            //新增一个record
            recordService.borrowBook(userId, bookId);
        }
        return true;
    }

    public double returnBook(String userId,String bookId) {
        BookOprationService bookOprationService = new BookOprationServiceImpl();
        RecordService recordService = new RecordServiceImpl();

        //还书
        bookOprationService.returnBook(bookId);

        // 0表示成功，正数表示逾期罚款？
        //读取record信息
        recordService.returnBook(userId, bookId);
        double overdue=returnBook(userId,bookId);
        return overdue;
    }

    public boolean pay(String userId, String bookId) {
        //record更改
        RecordService recordService = new RecordServiceImpl();
        return recordService.pay(userId, bookId);
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