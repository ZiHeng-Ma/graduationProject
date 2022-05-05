package com.ncepu.service.impl;

import com.ncepu.bean.ST_Student;
import com.ncepu.dao.StudentDao;
import com.ncepu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public ST_Student getStudentBySnm(int s_no) {
        return studentDao.getStudentBySnm(s_no);
    }
}
