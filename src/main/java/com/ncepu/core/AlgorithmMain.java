package com.ncepu.core;

import com.ncepu.bean.ST_Intrest;
import com.ncepu.bean.ST_Score;
import com.ncepu.util.AlgorithmData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 算法主类
 */
public class AlgorithmMain {

    int TOTAL_TRANS;

    /**
     * 传过来的map数据格式复杂，有无用数据，将map集合中有需要的内容提取出来，
     * 生成以工具类AlgorithmData为结构的数据集合，即事务集
     * @param param 所有的的数据map
     * @param min_sup 最小支持度
     * @param min_con 最小置信度
     * @return
     */
    public Map<String,String> algorithmMain(Map<ST_Score, ST_Intrest> param,int min_sup, int min_con){
        List<AlgorithmData> trans = new ArrayList<>();
        for (ST_Score score: param.keySet()){
            int S_Nm =  score.getS_Nm();
            int C_CO = score.getC_NO();
            int S_TO = score.getS_TO();
            ST_Intrest temp = param.get(score);
            String s_Indg = temp.getS_Indg();
            String s_Stha = temp.getS_Stha();
            String s_Hoco = temp.getS_Hoco();
            String s_Ptim = temp.getS_Ptim();
            String s_Un = temp.getS_Un();
            String s_Ef = temp.getS_Ef();
            AlgorithmData ad = new AlgorithmData(S_Nm,C_CO,S_TO,s_Indg,s_Stha,s_Hoco,s_Ptim,s_Un,s_Ef);
            trans.add(ad);
        }
        TOTAL_TRANS = trans.size();
        return Candidate.algorithm(trans,min_sup,min_con);
    }
}
