package edu.nju.libInfoSys.Dao;

import edu.nju.libInfoSys.Entity.RecordEntity;

import java.util.ArrayList;

public class UserInfoDaoImpl implements UserInfoDao {

//    @Override
//    public ArrayList<RecordEntity> getAllReports() {
//        return null;
//    }

    //该user所有借书记录
    @Override
    public ArrayList<RecordEntity> getReportsByUserId(String userId) {
        return null;
    }

    //该user的仍未缴费的记录 status=1
    @Override
    public ArrayList<RecordEntity> getOverdueReportsByUserId(String userId) {
        return null;
    }

    //总欠费
    @Override
    public double getOverduePenaltyByUserId(String userId) {
        return 0;
    }
}
