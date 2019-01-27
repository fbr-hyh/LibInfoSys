package main.java.edu.nju.libInfoSys.Service;

import main.java.edu.nju.libInfoSys.Entity.BookStrategy;

public interface BookOprationService {
    BookStrategy getBookStrategyById(int id);

    int getBookStatus(String bookId);

    boolean borrowBook(String bookId);

    boolean returnBook(String bookId);
}
