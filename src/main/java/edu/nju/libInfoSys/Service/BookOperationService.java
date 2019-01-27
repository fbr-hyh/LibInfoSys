package edu.nju.libInfoSys.Service;

import edu.nju.libInfoSys.Entity.BookStrategyEntity;

public interface BookOperationService {
    BookStrategyEntity getBookStrategyById(int id);

    BookStrategyEntity getBookStrategyByName(String name);

    int getBookStatus(String bookId);

    boolean borrowBook(String bookId);

    boolean returnBook(String bookId);

    boolean editBookPrice(String bookId, double price);
}
