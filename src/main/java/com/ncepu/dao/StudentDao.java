package com.ncepu.dao;

import com.ncepu.bean.ST_Score;
import com.ncepu.bean.ST_Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {

    public ST_Student getStudentBySnm(int s_no);

    public List<ST_Score> selectScoreBySnm(@Param("S_Nm") int S_Nm);

    public List<ST_Score> selectScoreByCno(@Param("C_NO") int C_NO, @Param("S_Nm") int S_Nm);
}
