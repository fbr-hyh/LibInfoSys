package edu.nju.libInfoSys;

import edu.nju.libInfoSys.Entity.User.*;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        //初始的借书策略 teacher 策略1   undergraduate 策略2  graduate 策略3

        UserEntity teacher = new Teacher("teacher", "123");
        UserEntity undergraduate = new Undergraduate("undergraduate", "123");
        UserEntity graduate = new Graduate("graduate", "123");
        UserEntity admin = new Administrator("admin", "123");

        //1 borrow method不同
        teacher.borrowBook("TP124.1-1");
        teacher.borrowBook("TP125.6-4");
        teacher.borrowBook("Q124.1-1");

        undergraduate.borrowBook("TP124.1-1");//已被借走
        undergraduate.borrowBook("TP126.6-4");
        undergraduate.borrowBook("Q124.2-1");  //没有权限

        //2 admin功能
        ((Administrator) admin).generateBorrowReport("teacher");
        ((Administrator) admin).generateOverduePenaltyReport("teacher");
        ((Administrator) admin).generateOverduePenalty("teacher");

        ((Administrator) admin).generateBorrowReport("undergraduate");
        ((Administrator) admin).generateOverduePenaltyReport("undergraduate");
        ((Administrator) admin).generateOverduePenalty("undergraduate");


        File file = new File("text");
        //3 提供不同的reader
        graduate.read("PDF",file);
        graduate.read("Word",file);
        graduate.read("EPUB",file);

        //4 当用户修改个人信息时，及时通知管理员
        undergraduate.setPassword("123123");


    }
//
//    private static final SessionFactory ourSessionFactory;
//
//    static {
//        try {
//            Configuration configuration = new Configuration();
//            configuration.configure();
//
//            ourSessionFactory = configuration.buildSessionFactory();
//        } catch (Throwable ex) {
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static Session getSession() throws HibernateException {
//        return ourSessionFactory.openSession();
//    }
//
//    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
//        try {
//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            session.close();
//        }
//    }

}