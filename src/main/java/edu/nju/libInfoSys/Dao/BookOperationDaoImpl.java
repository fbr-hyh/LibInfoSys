package edu.nju.libInfoSys.Dao;

import edu.nju.libInfoSys.Entity.BookEntity;
import edu.nju.libInfoSys.Entity.BookStrategyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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

        String hql = "from BookStrategyEntity where strategyId=:id ";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);

        if (query.list().size() == 0) {
            transaction.commit();
            return null;
        }
        BookStrategyEntity result = (BookStrategyEntity) query.getSingleResult();

        transaction.commit();
        return result;
    }

    @Override
    public BookStrategyEntity getBookStrategyByName(String name) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "from BookStrategyEntity where strategyName=:name ";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);

        if (query.list().size() == 0) {
            transaction.commit();
            return null;
        }
        BookStrategyEntity result = (BookStrategyEntity) query.getSingleResult();

        transaction.commit();
        return result;
    }

    @Override
    public int getBookStatus(String bookId) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "select bookStatus from BookEntity where bookId=:id ";
        Query query = session.createQuery(hql);
        query.setParameter("id", bookId);

        int result = Integer.valueOf((String) query.getSingleResult());

        transaction.commit();
        return result;
    }

    @Override
    public boolean setBookStatus(String bookId, int status) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "from BookEntity where bookId=:id";
        Query query = session.createQuery(hql);
        query.setParameter("id", bookId);

        if (query.list().size() == 0) {
            transaction.commit();
            return false;
        }
        BookEntity bookEntity = (BookEntity) query.getSingleResult();
        bookEntity.setBookStatus(status);

        session.update(bookEntity);
        transaction.commit();
        return true;
    }

    @Override
    public boolean modifyBookPrice(String bookId, double price) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "from BookEntity where bookId=:id";
        Query query = session.createQuery(hql);
        query.setParameter("id", bookId);

        if (query.list().size() == 0) {
            transaction.commit();
            return false;
        }
        BookEntity bookEntity = (BookEntity) query.getSingleResult();
        bookEntity.setBookPrice(price);

        session.update(bookEntity);
        transaction.commit();
        return true;
    }
}
