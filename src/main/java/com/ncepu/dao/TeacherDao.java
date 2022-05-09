package com.ncepu.dao;

import com.ncepu.bean.ST_Course;
import com.ncepu.bean.ST_Score;
import com.ncepu.bean.TE_Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {

    TE_Teacher getTeacherByTno(int t_no);

    List<ST_Score> selectScoreByTno(int T_No);

    void updateOneData(@Param("t_no") int t_no,
                       @Param("S_Nm")int S_Nm,
                       @Param("c_no")int c_no,
                       @Param("S_Ncor") int S_Ncor,
                       @Param("S_Mid") int S_Mid,
                       @Param("S_Fs")int S_Fs,
                       @Param("S_TO")int S_TO);

    void deleteOneData(@Param("t_no")int t_no,
                       @Param("c_no")int c_no);

    void insertOneData(@Param("T_No") int T_No,
                       @Param("S_Nm") int S_Nm,
                       @Param("C_NO") int C_NO,
                       @Param("S_Ncor")int S_Ncor,
                       @Param("S_Mid") int S_Mid,
                       @Param("S_Fs") int S_Fs,
                       @Param("S_TO") int S_TO);

    List<ST_Score> selectScoreByCno (@Param("C_NO") int C_NO);

}
