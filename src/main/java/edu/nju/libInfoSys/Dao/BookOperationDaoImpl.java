package edu.nju.libInfoSys.Dao;

import edu.nju.libInfoSys.Entity.BookStrategyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookOperationDaoImpl implements BookOperationDao {
    @Autowired
    protected SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public BookStrategyEntity getBookStrategyById(int id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

//        String hql = "from BookStrategyEntity where username=:name and password=:pw";
//        Query query = session.createQuery(hql);
//        query.setParameter("name", userId);
//        query.setParameter("pw", password);
//
//        if (query.list().size() == 0) {
//            transaction.commit();
//            return null;
//        }
//        UsersEntity result = (UsersEntity) query.getSingleResult();
//
//        transaction.commit();
//        return result;
        return null;
    }

    @Override
    public BookStrategyEntity getBookStrategyByName(String name) {
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
