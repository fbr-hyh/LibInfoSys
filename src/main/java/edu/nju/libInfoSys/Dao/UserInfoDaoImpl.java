package edu.nju.libInfoSys.Dao;

import edu.nju.libInfoSys.Entity.Record;

import java.util.ArrayList;

public class UserInfoDaoImpl implements UserInfoDao {

    @Override
    public ArrayList<Record> getAllReports() {
        return null;
    }

    @Override
    public ArrayList<Record> getReportsByUserId(String userId) {
        return null;
    }

    @Override
    public ArrayList<Record> getOverdueReportsByUserId(String userId) {
        return null;
    }

    @Override
    public double getOverduePenaltyByUserId(String userId) {
        return 0;
    }
}
