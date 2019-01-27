package edu.nju.libInfoSys.Service;

public class RecordServiceImpl implements RecordService {
    @Override
    public boolean borrowBook(String userId, String bookId) {
        //新增一个record
        return false;
    }

    @Override
    public double returnBook(String userId, String bookId,int borrowPeriods) {
        //计算overduePen 同时填入数据库中
        //填入returnTime
        //更改status，如果为0，则改status为2，如果>0，则改status为1
        return 0;
    }

    @Override
    public boolean pay(String userId, String bookId) {
        //将overdue改为0
        return false;
    }

    @Override
    public int getBorrowingNum(String userId) {  //正在借阅的数量 status=0
        return 0;
    }


}
