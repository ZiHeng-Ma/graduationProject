package com.ncepu.bean;

import lombok.Data;

import java.util.Date;

/**
 * 学生信息表
 */
@Data
public class ST_Student {

    private Date s_Year;//入学年份
    private int s_Nm;//学生学号
    private String s_Clas;//班级
    private String s_Nam;//姓名
    private String s_Sp;//专业
    private String s_Sex;//性别
    private String s_Ori;//籍贯
    private String s_Add;//家庭住址

}
