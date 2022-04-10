package com.ncepu.mapper;

import com.ncepu.bean.ST_Intrest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IntrestMapper {

    @Select("select * from ST_Intrest")
    List<ST_Intrest> getIntrest();
}
