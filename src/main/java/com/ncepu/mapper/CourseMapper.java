package com.ncepu.mapper;

import com.ncepu.bean.ST_Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {

    @Select("select * from ST_Course")
    List<ST_Course> getCourse();
}
