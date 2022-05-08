package com.ncepu.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlgorithmData {

    private int S_Nm;//学号
    private int C_NO;//课程代号
    private int S_TO;//总成绩
    private String s_Indg;//兴趣度
    private String s_Stha;//学习习惯
    private String s_Hoco;//作业完成
    private String s_Ptim;//实践时间
    private String s_Un;//对实践的认识
    private String s_Ef;//学习效果
}
