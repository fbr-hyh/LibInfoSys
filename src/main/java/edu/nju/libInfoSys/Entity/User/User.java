package edu.nju.libInfoSys.Entity.User;

import edu.nju.libInfoSys.Factory.StrategyFactory;
import edu.nju.libInfoSys.Service.BookOprationService;
import edu.nju.libInfoSys.Service.UserService;
import edu.nju.libInfoSys.Service.UserServiceImpl;
import edu.nju.libInfoSys.onlineReading.OnlineReader;
import edu.nju.libInfoSys.onlineReading.PDFReader;
import edu.nju.libInfoSys.onlineReading.Reader;

import java.io.File;
import java.util.ArrayList;

public class User {
    private String userId;
    private String password;
    private int userType;

    public User() {
    }

    public User(String userId, String password,int userType) {
        this.userId = userId;
        this.password = password;
        this.userType = userType;
    }


    public boolean borrowBook(String bookId) {

        boolean borrowResult = StrategyFactory.getStrategy(userType).borrowBook(userId, bookId);
        if (borrowResult) {
            System.out.println("借书成功 userId: " + userId + " bookId: " + bookId);
        } else {
            System.out.println("借书失败 userId: " + userId + " bookId: " + bookId);
        }
        return borrowResult;
    }

    public double returnBook(String bookId) {

        double overduePenalty = StrategyFactory.getStrategy(userType).returnBook(userId, bookId);
        if (overduePenalty > 0) {
            System.out.println("还书成功但已超期，需要交费: " + overduePenalty + "元");
        } else if (overduePenalty == 0){
            System.out.println("还书成功 userId: " + userId + " bookId: " + bookId);
        }else {
            System.out.println("还书失败 userId: " + userId + " bookId: " + bookId);
        }
        return overduePenalty;
    }

    public boolean pay(String bookId) {
        boolean borrowResult = StrategyFactory.getStrategy(userType).pay(userId, bookId);
        if (borrowResult) {
            System.out.println("缴费成功");
        } else {
            System.out.println("缴费失败");
        }
        return borrowResult;
    }

    public void notifyObservers(String message) {

        ArrayList<Administrator> administrators=new UserServiceImpl().getAllAdministrator();
        for (Administrator administrator : administrators) {
            administrator.update(message);
        }

    }
    public void read(String type, File file) {
        OnlineReader onlineReader = new OnlineReader(type);
        onlineReader.readFile(file);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyObservers(userId+"更改了密码");
    }
}
