package com.ncepu.mapper;

import com.ncepu.bean.TE_Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface TeacherMapper {

    @Select("selct * from ")
    List<TE_Teacher> getTeacher();
}
