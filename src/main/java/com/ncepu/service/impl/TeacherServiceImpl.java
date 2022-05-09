package com.ncepu.service.impl;

import com.ncepu.bean.ST_Course;
import com.ncepu.bean.ST_Score;
import com.ncepu.bean.TE_Teacher;
import com.ncepu.dao.TeacherDao;
import com.ncepu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao dao;

    @Override
    public TE_Teacher getTeacherByTno(int t_no) {
        return dao.getTeacherByTno(t_no);
    }

    @Override
    public List<ST_Score> selectScoreByTno(int T_No) {
        return dao.selectScoreByTno(T_No);
    }

    @Override
    public void updateOneData(int t_no,int S_Nm,int c_no, int S_Ncor, int S_Mid, int S_Fs, int S_TO) {
        dao.updateOneData(t_no, S_Nm, c_no, S_Ncor,  S_Mid,  S_Fs,  S_TO);
    }

    @Override
    public void deleteOneData(int t_no, int c_no) {
        dao.deleteOneData(t_no, c_no);
    }

    @Override
    public void insertOneData(int T_No, int S_Nm, int C_NO, int S_Ncor, int S_Mid, int S_Fs, int S_TO) {
        dao.insertOneData(T_No,S_Nm,C_NO,S_Ncor,S_Mid,S_Fs,S_TO);
    }

    @Override
    public List<ST_Score> selectScoreByCno(int C_NO) {
        return dao.selectScoreByCno(C_NO);
    }

}
