package edu.nju.libInfoSys.Entity;

import edu.nju.libInfoSys.Factory.ServiceFactory;
import edu.nju.libInfoSys.Service.BookOperationService;
import edu.nju.libInfoSys.Service.BookOperationServiceImpl;
import edu.nju.libInfoSys.Service.RecordService;
import edu.nju.libInfoSys.Service.RecordServiceImpl;

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


    public BookStrategyEntity() {
    }

    public BookStrategyEntity(int strategyId, String strategyName, int maxBorrowNum, int borrowPeriods, String blockedCategories) {
        this.strategyId = strategyId;
        this.strategyName = strategyName;
        this.maxBorrowNum = maxBorrowNum;
        this.borrowPeriods = borrowPeriods;
        this.blockedCategories = blockedCategories;
    }

    public boolean borrowBook(String userId, String bookId) {
        BookOperationService bookOprationService = ServiceFactory.getBookOperationService();
        RecordService recordService = ServiceFactory.getRecordService();

        //可能已被借走
        if (bookOprationService.getBookStatus(bookId) == 0) {
            System.out.println("该图书已被借走");
            return false;
        }
        // 在blockedCategories表中的书不能借
        String category = bookId.substring(0, 1);
        String[] blockedCategoryList = blockedCategories.split(",");

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
        } else if (recordService.getBorrowingNum(userId) >= maxBorrowNum) {  //maxBorrowNum
            System.out.println("该用户借阅图书数量已达上限");
        } else {
            //借阅图书 图书status:=1
            bookOprationService.borrowBook(bookId);
            //新增一个record
            recordService.borrowBook(userId, bookId);
        }
        return true;
    }

    public double returnBook(String userId, String bookId) {
        BookOperationService bookOprationService = ServiceFactory.getBookOperationService();
        RecordService recordService = ServiceFactory.getRecordService();

        //还书
        bookOprationService.returnBook(bookId);

        // 0表示成功，正数表示逾期罚款？
        //读取record信息
        double overdue = recordService.returnBook(userId, bookId, borrowPeriods);
        return overdue;
    }

}
