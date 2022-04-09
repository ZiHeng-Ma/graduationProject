package com.ncepu.bean;

import lombok.Data;

/**
 * 学生成绩表
 */
@Data
public class ST_Score {

    private int t_No;//职工编号
    private int c_No;//课程代号
    private int s_Ncor;//平时成绩
    private int s_Mid;//期中成绩
    private int s_Fs;//期末成绩
    private int s_To;//总成绩

}
