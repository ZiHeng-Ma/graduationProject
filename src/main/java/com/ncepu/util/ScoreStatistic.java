package com.ncepu.util;

import com.ncepu.bean.ST_Score;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreStatistic {

    public Map<String,Integer> scoreStatisticUtil(List<ST_Score> scores){
        Map<String,Integer> result = new HashMap<>();
        int fail = 0;
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i).getS_TO() < 60){
                fail++;
            }
        }
        int pass = scores.size()-fail;
        float f = pass/scores.size();
        int rate = (int)f*100;

        result.put("total",scores.size());
        result.put("fail",fail);
        result.put("pass",pass);
        result.put("rate",rate);
        return result;
    }
}
