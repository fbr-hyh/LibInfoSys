package edu.nju.libInfoSys.Dao;

import edu.nju.libInfoSys.Entity.User.Administrator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class UserDaoImpl implements UserDao {
    @Autowired
    protected SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public ArrayList<Administrator> getAllAdministrator() {
        Session session = getSession();

        ArrayList<Administrator> administrators = new ArrayList<>();
        try {
            Query query=session.createQuery("from UserEntity u where u.userType=?1");
            query.setParameter(1, 4);
            administrators = (ArrayList<Administrator>) query.getResultList();
        } catch (Exception e) {
            System.out.println("无管理员");
            return administrators;
        }
        return administrators;
    }
}
