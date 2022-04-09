package com.ncepu.bean;

import lombok.Data;

/**
 * 课程表
 */
@Data
public class ST_Course {

    private int c_No;//课程编号
    private String c_Name;//课程名
    private int c_Ttim;//讲授学时
    private int c_Prtim;//实践学时
    private String c_Natur;//课程性质
    private String c_Class;//课程类别
    private int c_Credit;//总学分
}
