package edu.nju.libInfoSys.Factory;

import edu.nju.libInfoSys.Entity.BookStrategyEntity;
import edu.nju.libInfoSys.Service.BookOperationService;
import edu.nju.libInfoSys.Service.BookOperationServiceImpl;

import java.util.InputMismatchException;

public  class StrategyFactory {
    private static BookOperationService bookOperationService =new BookOperationServiceImpl();
    private static BookStrategyEntity teacherStrategy;
    private static BookStrategyEntity undergraduateStrategy;
    private static BookStrategyEntity graduateStrategy;

    static {
        //初始策略
        teacherStrategy= bookOperationService.getBookStrategyById(1);
        undergraduateStrategy= bookOperationService.getBookStrategyById(2);
        graduateStrategy = bookOperationService.getBookStrategyById(3);

    }

    public static BookStrategyEntity getStrategy(int userType) {
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
                teacherStrategy = bookOperationService.getBookStrategyById(strategyId);
                System.out.println("替换借还书策略成功");
                break;
            case 2:
                undergraduateStrategy = bookOperationService.getBookStrategyById(strategyId);
                System.out.println("替换借还书策略成功");
                break;
            case 3:
                graduateStrategy = bookOperationService.getBookStrategyById(strategyId);
                System.out.println("替换借还书策略成功");
                break;
            default:
                throw new InputMismatchException();
        }
    }

    public void setStrategy(int userType, String strategyName) {
        switch (userType) {
            case 1:
                teacherStrategy = bookOperationService.getBookStrategyByName(strategyName);
                System.out.println("替换借还书策略成功");
                break;
            case 2:
                undergraduateStrategy = bookOperationService.getBookStrategyByName(strategyName);
                System.out.println("替换借还书策略成功");
                break;
            case 3:
                graduateStrategy = bookOperationService.getBookStrategyByName(strategyName);
                System.out.println("替换借还书策略成功");
                break;
            default:
                throw new InputMismatchException();
        }
    }
    
}
