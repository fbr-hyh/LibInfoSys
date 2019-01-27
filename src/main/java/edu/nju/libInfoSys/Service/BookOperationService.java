package main.java.edu.nju.libInfoSys.Service;

import main.java.edu.nju.libInfoSys.Entity.BookStrategy;

public interface BookOperationService {
    BookStrategy getBookStrategyById(int id);

    BookStrategy getBookStrategyByName(String name);

    int getBookStatus(String bookId);

    boolean borrowBook(String bookId);

    boolean returnBook(String bookId);
}
