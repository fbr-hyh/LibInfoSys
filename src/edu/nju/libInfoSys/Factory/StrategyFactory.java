package edu.nju.libInfoSys.Factory;

import edu.nju.libInfoSys.Entity.BookStrategy;

import java.util.InputMismatchException;

public  class StrategyFactory {
    private static BookStrategy teacherStrategy;
    private static BookStrategy graduateStrategy;
    private static BookStrategy undergraduateStrategy;

    static {
        //初始策略
        // TODO: 2019-01-26
    }
    public static BookStrategy getStrategy(int userType) {
        switch (userType) {
            case 1:
                return teacherStrategy;
            case 2:
                return graduateStrategy;
            case 3:
                return undergraduateStrategy;
            default:
                throw new InputMismatchException();
        }
    }

    public void setStrategy(int userType, int strategyId) {
        // TODO: 2019-01-26  
    }

    public void setStrategy(int userType, String strategyName) {
        // TODO: 2019-01-26  
    }
    
}
