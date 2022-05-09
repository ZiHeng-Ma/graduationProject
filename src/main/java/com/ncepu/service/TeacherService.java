package com.ncepu.service;

import com.ncepu.bean.ST_Course;
import com.ncepu.bean.ST_Score;
import com.ncepu.bean.TE_Teacher;

import java.util.List;

public interface TeacherService {

    public TE_Teacher getTeacherByTno(int t_no);

    public List<ST_Score> selectScoreByTno(int T_No);

    public void updateOneData(int t_no,int S_Nm,int c_no,int S_Ncor,int S_Mid,int S_Fs,int S_TO);

    public void deleteOneData(int t_no,int c_no);

    public void insertOneData(int T_No,int S_Nm,int C_NO,int S_Ncor,int S_Mid,int S_Fs,int S_TO);

    public List<ST_Score> selectScoreByCno(int C_NO);

}
