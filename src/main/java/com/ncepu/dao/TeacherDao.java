package com.ncepu.dao;

import com.ncepu.bean.ST_Course;
import com.ncepu.bean.ST_Score;
import com.ncepu.bean.TE_Teacher;

import java.util.List;

public interface TeacherDao {

    TE_Teacher getTeacherByTno(int t_no);

    List<ST_Score> selectAllByTno(int T_No);
}
