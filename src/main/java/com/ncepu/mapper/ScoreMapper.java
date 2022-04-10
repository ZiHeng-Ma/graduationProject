package com.ncepu.mapper;

import com.ncepu.bean.ST_Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScoreMapper {

    @Select("select * from ST_Score")
    List<ST_Score> getScore();
}
