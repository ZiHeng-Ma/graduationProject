package com.ncepu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 教师信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TE_Teacher {

    private int T_No;//职工编号
    private String T_Name;//姓名
    private String T_Sex;//性别
    private String T_Eback;//学历
    private String T_Deg;//学位
    private String T_Sch;//毕业学校
    private String T_Sta;//所属院系
    private int T_Age;//教龄
    private String T_Nu;//身份证号
    private String T_Poa;//企业经历

}
