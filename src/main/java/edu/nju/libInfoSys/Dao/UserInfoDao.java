package edu.nju.libInfoSys.Dao;

import edu.nju.libInfoSys.Entity.Record;

import java.util.ArrayList;

public interface UserInfoDao {

    ArrayList<Record> getAllReports();

    ArrayList<Record> getReportsByUserId(String userId);

    ArrayList<Record> getOverdueReportsByUserId(String userId);

    double getOverduePenaltyByUserId(String userId); //status==1

}
