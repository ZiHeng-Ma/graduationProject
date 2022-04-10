package com.ncepu.service;

import com.ncepu.bean.ST_Student;
import com.ncepu.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper mapper;

    public List<ST_Student> getAll(){
        return mapper.getAll();
    }

    public ST_Student getStudentByNo(Integer no){
        return mapper.getStudentByNo(no);
    }
}
