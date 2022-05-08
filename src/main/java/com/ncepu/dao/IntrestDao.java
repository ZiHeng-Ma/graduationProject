package com.ncepu.dao;

import com.ncepu.bean.ST_Intrest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IntrestDao {

    ST_Intrest getIntrestBySnm(@Param("S_Nm") int S_Nm);
}
