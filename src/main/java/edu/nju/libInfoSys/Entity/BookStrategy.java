package edu.nju.libInfoSys.Entity;

import edu.nju.libInfoSys.Service.BookOperationService;
import edu.nju.libInfoSys.Service.BookOperationServiceImpl;
import edu.nju.libInfoSys.Service.RecordService;
import edu.nju.libInfoSys.Service.RecordServiceImpl;

public class BookStrategy {
    private int strategyId;
    private String strategyName;
    private int maxBorrowNum;
    private int borrowPeriods;
    private String blockedCategories;

    public BookStrategy() {
    }

    public BookStrategy(int strategyId, String strategyName, int maxBorrowNum, int borrowPeriods, String blockedCategories) {
        this.strategyId = strategyId;
        this.strategyName = strategyName;
        this.maxBorrowNum = maxBorrowNum;
        this.borrowPeriods = borrowPeriods;
        this.blockedCategories = blockedCategories;
    }

    public boolean borrowBook(String userId,String bookId) {
        BookOperationService bookOprationService = new BookOperationServiceImpl();
        RecordService recordService = new RecordServiceImpl();

        //可能已被借走
        if (bookOprationService.getBookStatus(bookId) == 0) {
            System.out.println("该图书已被借走");
            return false;
        }
        // 在blockedCategories表中的书不能借
        String category = bookId.substring(0, 1);
        String[] blockedCategoryList=blockedCategories.split(",");

        boolean contain = false;
        for (String str : blockedCategoryList) {
            if (str.equals(category)) {
                contain = true;
                break;
            }
        }
        if (contain) {
            System.out.println("该用户不允许借阅该类图书: " + category);
            return false;
        } else if (recordService.getBorrowingNum(userId)>=maxBorrowNum) {  //maxBorrowNum
            System.out.println("该用户借阅图书数量已达上限");
        } else {
            //借阅图书 图书status:=1
            bookOprationService.borrowBook(bookId);
            //新增一个record
            recordService.borrowBook(userId, bookId);
        }
        return true;
    }

    public double returnBook(String userId,String bookId) {
        BookOperationService bookOprationService = new BookOperationServiceImpl();
        RecordService recordService = new RecordServiceImpl();

        //还书
        bookOprationService.returnBook(bookId);

        // 0表示成功，正数表示逾期罚款？
        //读取record信息
        double overdue=recordService.returnBook(userId, bookId,borrowPeriods);
        return overdue;
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

    public String getBlockedCategories() {
        return blockedCategories;
    }

    public void setBlockedCategories(String blockedCategories) {
        this.blockedCategories = blockedCategories;
    }
}
