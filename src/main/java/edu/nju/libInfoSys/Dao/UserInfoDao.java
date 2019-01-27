package edu.nju.libInfoSys.Dao;

import edu.nju.libInfoSys.Entity.RecordEntity;

import java.util.ArrayList;

public interface UserInfoDao {

//    ArrayList<RecordEntity> getAllReports();

    ArrayList<RecordEntity> getReportsByUserId(String userId);

    ArrayList<RecordEntity> getOverdueReportsByUserId(String userId);

    double getOverduePenaltyByUserId(String userId); //status==1

    void modifyPassword(String userId, String newPassword);

}
