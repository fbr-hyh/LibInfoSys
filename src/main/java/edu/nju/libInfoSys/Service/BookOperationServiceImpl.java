package edu.nju.libInfoSys.Service;

import edu.nju.libInfoSys.Dao.BookOperationDao;
import edu.nju.libInfoSys.Dao.BookOperationDaoImpl;
import edu.nju.libInfoSys.Entity.BookStrategyEntity;

public class BookOperationServiceImpl implements BookOperationService {
    BookOperationDao bookOperationDao = new BookOperationDaoImpl();
    @Override
    public BookStrategyEntity getBookStrategyById(int id) {
        return bookOperationDao.getBookStrategyById(id);
    }

    @Override
    public BookStrategyEntity getBookStrategyByName(String name) {
        return bookOperationDao.getBookStrategyByName(name);
    }

    @Override
    public int getBookStatus(String bookId) {
        return bookOperationDao.getBookStatus(bookId);
    }

    @Override
    public boolean borrowBook(String bookId) {
        return bookOperationDao.setBookStatus(bookId,0);
    }

    @Override
    public boolean returnBook(String bookId) {
        return bookOperationDao.setBookStatus(bookId,1);
    }

    @Override
    public boolean editBookPrice(String bookId, double price) {
        return bookOperationDao.modifyBookPrice(bookId,price);
    }
}
