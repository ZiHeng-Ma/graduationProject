package com.ncepu.service;

import com.ncepu.bean.ST_Score;
import com.ncepu.bean.ST_Student;

import java.util.List;

public interface StudentService {

    public ST_Student getStudentBySnm(int s_no);

    public List<ST_Score> selectScoreBySnm(int S_Nm);

    public List<ST_Score> selectScoreByCno(int C_NO,int S_Nm);
}
