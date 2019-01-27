package edu.nju.libInfoSys.Dao;

import edu.nju.libInfoSys.Entity.BookStrategy;

public class BookOperationDaoImpl implements BookOperationDao {
    @Override
    public BookStrategy getBookStrategyById(int id) {
        return null;
    }

    @Override
    public BookStrategy getBookStrategyByName(String name) {
        return null;
    }

    @Override
    public int getBookStatus(String bookId) {
        return 0;
    }

    @Override
    public boolean setBookStatus(String bookId, int status) {
        return false;
    }

    @Override
    public boolean modifyBookPrice(String bookId, double price) {
        return false;
    }
}
