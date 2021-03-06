package edu.nju.libInfoSys.Entity.User;

import edu.nju.libInfoSys.Factory.ServiceFactory;
import edu.nju.libInfoSys.Factory.StrategyFactory;
import edu.nju.libInfoSys.Service.RecordService;
import edu.nju.libInfoSys.Service.UserInfoService;
import edu.nju.libInfoSys.onlineReading.OnlineReader;

import javax.persistence.*;
import java.io.File;
import java.util.ArrayList;

@Entity
@Table(name = "User", schema = "libinfo")
public class UserEntity {
    private String userId;
    private String password;
    private int userType; // 1 2 3 4 teacher undergr  gra  admin

    @Id
    @Column(name = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "userType")
    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userType != that.userType) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + userType;
        return result;
    }

    public UserEntity() {
    }

    public UserEntity(String userId, String password, int userType) {
        this.userId = userId;
        this.password = password;
        this.userType = userType;
    }

    public boolean modifyPassword(String newPassword) {

        if (newPassword.equals(this.password)) {
            return false;
        }
        UserInfoService userInfoService = ServiceFactory.getUserInfoService();
        userInfoService.modifyPassword(userId, newPassword);
        notifyObservers(userId + "更改了密码");
        return true;
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
        } else if (overduePenalty == 0) {
            System.out.println("还书成功 userId: " + userId + " bookId: " + bookId);
        } else {
            System.out.println("还书失败 userId: " + userId + " bookId: " + bookId);
        }
        return overduePenalty;
    }

    public boolean pay(String recordId) {
        RecordService recordService = ServiceFactory.getRecordService();
        boolean borrowResult = recordService.pay(recordId);
        if (borrowResult) {
            System.out.println("缴费成功");
        } else {
            System.out.println("缴费失败");
        }
        return borrowResult;
    }

    public void notifyObservers(String message) {

        ArrayList<Administrator> administrators = ServiceFactory.getUserService().getAllAdministrator();
        for (Administrator administrator : administrators) {
            administrator.update(message);
        }

    }

    public void read(String type, File file) {
        OnlineReader onlineReader = new OnlineReader(type);
        onlineReader.readFile(file);
    }
}
