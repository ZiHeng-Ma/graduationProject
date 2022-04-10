package com.ncepu.mapper;

import com.ncepu.bean.TE_Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface TeacherMapper {

    @Select("select * from TE_Teacher")
    List<TE_Teacher> getAll();

    @Select("select * from TE_Teacher where T_No = #{no}")
    TE_Teacher getTeacherByNo(Integer no);
}
