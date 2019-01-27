package edu.nju.libInfoSys.Dao;

import edu.nju.libInfoSys.Entity.RecordEntity;
import edu.nju.libInfoSys.Entity.User.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {
    @Autowired
    protected SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

//    @Override
//    public ArrayList<RecordEntity> getAllReports() {
//        return null;
//    }

    //该user所有借书记录
    @Override
    public ArrayList<RecordEntity> getReportsByUserId(String userId) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        ArrayList<RecordEntity> result = new ArrayList<>();

        List<RecordEntity> recordEntities;
        Query query = session.createQuery("from RecordEntity r where r.userId=?1");
        query.setParameter(1, userId);
        recordEntities = (List<RecordEntity>) query.list();


        if (recordEntities.size() == 0)
            System.out.println("该用户无借书记录");

        for (RecordEntity recordEntity : recordEntities) {
            result.add(recordEntity);
        }
        transaction.commit();
        return result;
    }

    //该user的仍未缴费的记录 status=1
    @Override
    public ArrayList<RecordEntity> getOverdueReportsByUserId(String userId) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        ArrayList<RecordEntity> recordEntities;
        Query query = session.createQuery("from RecordEntity r where r.userId=?1 and r.recordStatus=?2");
        query.setParameter(1, userId);
        query.setParameter(2, 1);//欠费状态
        recordEntities = (ArrayList<RecordEntity>) query.list();

        if (recordEntities.size() == 0)
            System.out.println("该用户暂无欠费");

        transaction.commit();
        return recordEntities;
    }

    //总欠费
    @Override
    public double getOverduePenaltyByUserId(String userId) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        double overdue;

        Query query = session.createQuery("select sum(r.overduePenalty) from RecordEntity r where r.userId=?1 and r.recordStatus=?2");
        query.setParameter(1, userId);
        query.setParameter(2, 1);//欠费状态

        if (query.getSingleResult() == null) {
            transaction.commit();
            return 0;
        }
        overdue = Double.parseDouble(query.getSingleResult().toString());

        transaction.commit();
        return overdue;
    }

    @Override
    public void modifyPassword(String userId, String newPassword) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from UserEntity where userId=:id");
        query.setParameter("id", userId);
        UserEntity userEntity = (UserEntity) query.getSingleResult();
        userEntity.setPassword(newPassword);
        session.update(userEntity);

        transaction.commit();
    }


}
