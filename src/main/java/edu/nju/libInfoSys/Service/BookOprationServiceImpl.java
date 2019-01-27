package edu.nju.libInfoSys.Service;

import edu.nju.libInfoSys.Entity.BookStrategy;

public class BookOprationServiceImpl implements BookOprationService {
    @Override
    public BookStrategy getBookStrategyById(int id) {
        return null;
    }

    @Override
    public int getBookStatus(String bookId) {
        return 0;
    }

    @Override
    public boolean borrowBook(String bookId) {
        return false;
    }

    @Override
    public boolean returnBook(String bookId) {
        return false;
    }
}
