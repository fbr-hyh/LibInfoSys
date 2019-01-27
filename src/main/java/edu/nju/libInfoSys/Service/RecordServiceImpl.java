package edu.nju.libInfoSys.Service;

import edu.nju.libInfoSys.Dao.RecordDao;
import edu.nju.libInfoSys.Dao.RecordDaoImpl;
import edu.nju.libInfoSys.Entity.Record;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class RecordServiceImpl implements RecordService {
    RecordDao recordDao = new RecordDaoImpl();

    @Override
    public boolean borrowBook(String userId, String bookId) {
        //新增一个record
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return recordDao.add(userId, bookId, timestamp);
    }

    @Override
    public double returnBook(String userId, String bookId,int borrowPeriods) {
        //计算overduePen
        Timestamp returnTime = new Timestamp(System.currentTimeMillis());

        Record record = recordDao.getNotReturnRecord(userId, bookId);
        Timestamp borrowTime = record.getBorrowTime();

        long t1 = returnTime.getTime();
        long t2 = borrowTime.getTime();
        double overduePenalty = 0;
        int status = 2;
        int days=(int) ((t1 - t2)/(1000*60*60*24));
        if (days > borrowPeriods) {
            overduePenalty = (double)(days - borrowPeriods) * 0.2;
            status = 1;
        }

        //同时填入数据库中
        //填入returnTime
        //更改status，如果为0，则改status为2，如果>0，则改status为1
        recordDao.setReturnedOverdueAndStatus(record.getRecordId(), returnTime, overduePenalty, status);
        return overduePenalty;
    }

    @Override
    public boolean pay(String recordId) {
        //将overdue改为0
        return recordDao.setOverdue(recordId, 0);
    }

    @Override
    public int getBorrowingNum(String userId) {
        //正在借阅的数量 status=0
        return recordDao.getBorrowingNumByUserId(userId);
    }

}
