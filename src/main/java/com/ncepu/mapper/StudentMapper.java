package com.ncepu.mapper;

import com.ncepu.bean.ST_Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface StudentMapper {

    @Select("select * from ST_Student)")
    List<ST_Student> getAll();

    @Select("select * from ST_Student where s_nm = #{no}")
    ST_Student getStudentByNo(Integer no);
}
