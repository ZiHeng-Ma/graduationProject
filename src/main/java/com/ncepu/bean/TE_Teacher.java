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

    private int t_No;//职工编号
    private String t_Name;//姓名
    private String t_Sex;//性别
    private String t_Eback;//学历
    private String t_Deg;//学位
    private String t_Sch;//毕业学校
    private String t_Sta;//所属院系
    private int t_age;//教龄
    private String t_Nu;//身份证号
    private String t_Poa;//企业经历

}
