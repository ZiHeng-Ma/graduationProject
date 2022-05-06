package com.ncepu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生成绩表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ST_Score {

    private int T_No;//职工编号
    private int S_Nm;//学号
    private int C_NO;//课程代号
    private int S_Ncor;//平时成绩
    private int S_Mid;//期中成绩
    private int S_Fs;//期末成绩
    private int S_TO;//总成绩

}
