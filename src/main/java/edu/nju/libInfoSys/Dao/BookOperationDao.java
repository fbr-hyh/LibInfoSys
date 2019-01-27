package edu.nju.libInfoSys.Dao;

import edu.nju.libInfoSys.Entity.BookStrategy;

public interface BookOperationDao {
    BookStrategy getBookStrategyById(int id);
    BookStrategy getBookStrategyByName(String name);
    int getBookStatus(String bookId);
    boolean setBookStatus(String bookId,int status);
    boolean modifyBookPrice(String bookId, double price);

}
