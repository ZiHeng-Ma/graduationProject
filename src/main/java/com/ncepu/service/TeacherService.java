package com.ncepu.service;

import com.ncepu.bean.TE_Teacher;
import com.ncepu.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherMapper mapper;

    public List<TE_Teacher> getAll(){
        return mapper.getAll();
    }

    public TE_Teacher getTeacherByNo(Integer no){
        return mapper.getTeacherByNo(no);
    }
}
