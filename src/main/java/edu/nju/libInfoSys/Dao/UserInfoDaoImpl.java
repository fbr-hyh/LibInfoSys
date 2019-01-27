package edu.nju.libInfoSys.Dao;

import edu.nju.libInfoSys.Entity.RecordEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

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
        ArrayList<RecordEntity> recordEntities = new ArrayList<>();
        try {
            Query query=session.createQuery("from RecordEntity r where r.userId=?1");
            query.setParameter(1, userId);
            recordEntities = (ArrayList<RecordEntity>) query.getResultList();
        } catch (Exception e) {
            System.out.println("该用户无借书记录");
            return recordEntities;
        }
        return recordEntities;
    }

    //该user的仍未缴费的记录 status=1
    @Override
    public ArrayList<RecordEntity> getOverdueReportsByUserId(String userId) {
        Session session = getSession();
        ArrayList<RecordEntity> recordEntities = new ArrayList<>();
        try {
            Query query=session.createQuery("from RecordEntity r where r.userId=?1 and r.recordStatus=?2");
            query.setParameter(1, userId);
            query.setParameter(2, 1);//欠费状态
            recordEntities = (ArrayList<RecordEntity>) query.getResultList();
        } catch (Exception e) {
            System.out.println("该用户暂无欠费");
            return recordEntities;
        }
        return recordEntities;
    }

    //总欠费
    @Override
    public double getOverduePenaltyByUserId(String userId) {
        Session session = getSession();
        double overdue=0;
        Query query=session.createQuery("select sum(r.overduePenalty) from RecordEntity r where r.userId=?1 and r.recordStatus=?2");
        query.setParameter(1, userId);
        query.setParameter(2, 1);//欠费状态
        overdue = Double.parseDouble(query.getSingleResult().toString());
        return overdue;
    }
}
