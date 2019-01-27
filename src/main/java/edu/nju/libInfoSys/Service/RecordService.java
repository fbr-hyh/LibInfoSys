package main.java.edu.nju.libInfoSys.Service;


public interface RecordService {
    boolean borrowBook(String userId,String bookId);

    double returnBook(String userId, String bookId,int borrowPeriods);

    boolean pay(String userId, String bookId);

    int getBorrowingNum(String userId);

}
