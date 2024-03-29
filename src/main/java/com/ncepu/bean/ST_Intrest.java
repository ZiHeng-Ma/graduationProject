package com.ncepu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生学习兴趣表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ST_Intrest {

    private int S_Nm;//学号
    private String s_Indg;//兴趣度
    private String s_Stha;//学习习惯
    private String s_Hoco;//作业完成
    private String s_Ptim;//实践时间
    private String s_Un;//对实践的认识
    private String s_Ef;//学习效果

}
