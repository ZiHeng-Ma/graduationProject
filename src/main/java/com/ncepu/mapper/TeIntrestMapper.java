package com.ncepu.mapper;

import com.ncepu.bean.TE_Teintrest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface TeIntrestMapper {

    @Select("select * from TE_TeIntrest")
    List<TE_Teintrest> getTeIntrest();
}
