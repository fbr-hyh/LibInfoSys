package edu.nju.libInfoSys.Service;


public interface RecordService {
    boolean borrowBook(String userId,String bookId);

    double returnBook(String userId, String bookId,int borrowPeriods);

    boolean pay(String recordId);

    int getBorrowingNum(String userId);

}
