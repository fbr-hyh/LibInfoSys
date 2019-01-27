package edu.nju.libInfoSys.Dao;

import edu.nju.libInfoSys.Entity.Record;

import java.util.ArrayList;

public class UserInfoDaoImpl implements UserInfoDao {

//    @Override
//    public ArrayList<Record> getAllReports() {
//        return null;
//    }

    //该user所有借书记录
    @Override
    public ArrayList<Record> getReportsByUserId(String userId) {
        return null;
    }

    //该user的仍未缴费的记录 status=1
    @Override
    public ArrayList<Record> getOverdueReportsByUserId(String userId) {
        return null;
    }

    //总欠费
    @Override
    public double getOverduePenaltyByUserId(String userId) {
        return 0;
    }
}
