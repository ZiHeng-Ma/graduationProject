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
    public List<ST_Score> selectAllByTno(int T_No) {
        return dao.selectAllByTno(T_No);
    }
}
