package edu.nju.libInfoSys.Service;

import edu.nju.libInfoSys.Entity.BookStrategy;

public interface BookOprationService {
    BookStrategy getBookStrategyById(int id);

    int getBookStatus(String bookId);

    boolean borrowBook(String bookId);

    boolean returnBook(String bookId);
}