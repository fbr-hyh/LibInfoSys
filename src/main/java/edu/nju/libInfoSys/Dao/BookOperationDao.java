package edu.nju.libInfoSys.Dao;

import edu.nju.libInfoSys.Entity.BookStrategyEntity;

public interface BookOperationDao {
    BookStrategyEntity getBookStrategyById(int id);

    BookStrategyEntity getBookStrategyByName(String name);
    int getBookStatus(String bookId);
    boolean setBookStatus(String bookId,int status);
    boolean modifyBookPrice(String bookId, double price);

}
