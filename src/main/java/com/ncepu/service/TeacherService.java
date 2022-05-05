package com.ncepu.service;

import com.ncepu.bean.ST_Course;
import com.ncepu.bean.ST_Score;
import com.ncepu.bean.TE_Teacher;

import java.util.List;

public interface TeacherService {

    public TE_Teacher getTeacherByTno(int t_no);

    public List<ST_Score> selectAllByTno(int T_No);
}
