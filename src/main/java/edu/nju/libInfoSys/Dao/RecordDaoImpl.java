package edu.nju.libInfoSys.Dao;

import edu.nju.libInfoSys.Entity.RecordEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class RecordDaoImpl implements RecordDao {
    @Autowired
    protected SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public boolean add(String userId, String bookId, Timestamp borrowTime) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        RecordEntity recordEntity = new RecordEntity(0, bookId, userId, borrowTime, null, 0, 0);
        session.save(recordEntity);

        transaction.commit();
        return false;
    }

    @Override
    public RecordEntity getNotReturnRecord(String bookId, String userId) { //status=0
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "from RecordEntity where bookId=:book and userId=:user and recordStatus=0";
        Query query = session.createQuery(hql);
        query.setParameter("book", bookId);
        query.setParameter("user", userId);

        if (query.list().size() == 0) {
            transaction.commit();
            return null;
        }
        RecordEntity result = (RecordEntity) query.getSingleResult();

        transaction.commit();
        return result;
    }

    @Override
    public boolean setReturnedOverdueAndStatus(int recordId, Timestamp returnTime, double overduePen, int status) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "from RecordEntity where recordId=:id";
        Query query = session.createQuery(hql);
        query.setParameter("id", recordId);

        if (query.list().size() == 0) {
            transaction.commit();
            return false;
        }
        RecordEntity result = (RecordEntity) query.getSingleResult();
        result.setReturnTime(returnTime);
        result.setOverduePenalty(overduePen);
        result.setRecordStatus(status);
        session.update(result);

        transaction.commit();
        return true;
    }

    @Override
    public boolean setOverdue(String recordId, double overdue) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "from RecordEntity where recordId=:id";
        Query query = session.createQuery(hql);
        query.setParameter("id", recordId);

        if (query.list().size() == 0) {
            transaction.commit();
            return false;
        }
        RecordEntity result = (RecordEntity) query.getSingleResult();
        result.setOverduePenalty(overdue);
        session.update(result);

        transaction.commit();
        return true;
    }

    @Override
    public int getBorrowingNumByUserId(String userId) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "from RecordEntity where userId=:user";
        Query query = session.createQuery(hql);
        query.setParameter("user", userId);


        int result = query.list().size();
        transaction.commit();
        return result;
    }
}
