package edu.nju.libInfoSys.Factory;

import edu.nju.libInfoSys.Entity.BookStrategy;
import edu.nju.libInfoSys.Service.BookOprationService;
import edu.nju.libInfoSys.Service.BookOprationServiceImpl;

import java.util.InputMismatchException;

public  class StrategyFactory {
    private static BookOprationService bookOprationService=new BookOprationServiceImpl();
    private static BookStrategy teacherStrategy;
    private static BookStrategy undergraduateStrategy;
    private static BookStrategy graduateStrategy;

    static {
        //初始策略
        teacherStrategy= bookOprationService.getBookStrategyById(1);
        undergraduateStrategy= bookOprationService.getBookStrategyById(2);
        graduateStrategy = bookOprationService.getBookStrategyById(3);

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
        switch (userType) {
            case 1:
                teacherStrategy = bookOprationService.getBookStrategyById(strategyId);
                System.out.println("替换借还书策略成功");
                break;
            case 2:
                undergraduateStrategy = bookOprationService.getBookStrategyById(strategyId);
                System.out.println("替换借还书策略成功");
                break;
            case 3:
                graduateStrategy = bookOprationService.getBookStrategyById(strategyId);
                System.out.println("替换借还书策略成功");
                break;
            default:
                throw new InputMismatchException();
        }
    }

    public void setStrategy(int userType, String strategyName) {
        switch (userType) {
            case 1:
                teacherStrategy = bookOprationService.getBookStrategyByName(strategyName);
                System.out.println("替换借还书策略成功");
                break;
            case 2:
                undergraduateStrategy = bookOprationService.getBookStrategyByName(strategyName);
                System.out.println("替换借还书策略成功");
                break;
            case 3:
                graduateStrategy = bookOprationService.getBookStrategyByName(strategyName);
                System.out.println("替换借还书策略成功");
                break;
            default:
                throw new InputMismatchException();
        }
    }
    
}
