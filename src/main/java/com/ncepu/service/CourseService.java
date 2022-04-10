package com.ncepu.service;

import com.ncepu.bean.ST_Course;
import com.ncepu.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseMapper mapper;

    public List<ST_Course> getCourse(){
        return mapper.getCourse();
    }
}
