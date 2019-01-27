package edu.nju.libInfoSys.Factory;

import edu.nju.libInfoSys.Service.BookOperationService;
import edu.nju.libInfoSys.Service.RecordService;
import edu.nju.libInfoSys.Service.UserInfoService;
import edu.nju.libInfoSys.Service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceFactory {
    private static ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
    public static BookOperationService getBookOperationService(){
        BookOperationService bookOperationService = (BookOperationService) ctx.getBean("BookOperationService");
        return bookOperationService;
    }
    public static RecordService getRecordService(){
        RecordService recordService = (RecordService)ctx.getBean("RecordService");
        return recordService;
    }
    public static UserInfoService getUserInfoService(){
        UserInfoService userInfoService = (UserInfoService) ctx.getBean("UserInfoService");
        return userInfoService;
    }
    public static UserService getUserService(){
        UserService userService = (UserService) ctx.getBean("UserService");
        return userService;
    }
}
