package edu.nju.libInfoSys.Service;


public interface RecordService {
    boolean borrowBook(String userId,String bookId);

    double returnBook(String userId, String bookId);

    boolean pay(String userId, String bookId);

}
