package edu.nju.libInfoSys.Service;

import edu.nju.libInfoSys.Dao.BookOperationDao;
import edu.nju.libInfoSys.Dao.BookOperationDaoImpl;
import edu.nju.libInfoSys.Entity.BookStrategy;

public class BookOperationServiceImpl implements BookOperationService {
    BookOperationDao bookOperationDao = new BookOperationDaoImpl();

    @Override
    public BookStrategy getBookStrategyById(int id) {
        return bookOperationDao.getBookStrategyById(id);
    }

    @Override
    public BookStrategy getBookStrategyByName(String name) {
        return bookOperationDao.getBookStrategyByName(name);
    }

    @Override
    public int getBookStatus(String bookId) {
        return bookOperationDao.getBookStatus(bookId);
    }

    @Override //0被借阅
    public boolean borrowBook(String bookId) {
        return bookOperationDao.setBookStatus(bookId,0);
    }

    @Override //1未被借阅
    public boolean returnBook(String bookId) {
        return bookOperationDao.setBookStatus(bookId,1);
    }
}
