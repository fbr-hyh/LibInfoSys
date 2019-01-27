package edu.nju.libInfoSys.Dao;

import edu.nju.libInfoSys.Entity.User.Administrator;
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
public class UserDaoImpl implements UserDao {
    @Autowired
    protected SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public ArrayList<Administrator> getAllAdministrator() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        List<UserEntity> administrators;
        ArrayList<Administrator> result = new ArrayList<>();


        Query query = session.createQuery("from UserEntity u where u.userType=?1");
        query.setParameter(1, 4);
        administrators = (List<UserEntity>) query.list();
        for (UserEntity userEntity : administrators) {
            result.add(new Administrator(userEntity.getUserId(), userEntity.getPassword()));
        }


        if (administrators.size() == 0)
            System.out.println("无管理员");

        transaction.commit();
        return result;
    }
}
