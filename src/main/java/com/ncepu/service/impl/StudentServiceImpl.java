package com.ncepu.service.impl;

import com.ncepu.bean.ST_Score;
import com.ncepu.bean.ST_Student;
import com.ncepu.dao.StudentDao;
import com.ncepu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public ST_Student getStudentBySnm(int s_no) {
        return studentDao.getStudentBySnm(s_no);
    }

    @Override
    public List<ST_Score> selectScoreBySnm(int S_Nm) {
        return studentDao.selectScoreBySnm(S_Nm);
    }

    @Override
    public List<ST_Score> selectScoreByCno(int C_NO, int S_Nm) {
        return studentDao.selectScoreByCno(C_NO,S_Nm);
    }
}
