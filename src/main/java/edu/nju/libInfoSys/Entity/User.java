package edu.nju.libInfoSys.Entity;

public class User {
    private String userId;
    private String password;

    public User() {
    }

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }


    public boolean borrowBook(String bookId) {
        // TODO: 2019-01-26  
        return true;
    }

    public double returnBook(String bookId) {
        // TODO: 2019-01-26  
        return 0;
    }

    public void notifyObservers(String message) {
        // TODO: 2019-01-26
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
    }
}
