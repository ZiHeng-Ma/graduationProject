package com.ncepu.core;

import com.ncepu.util.AlgorithmData;

import java.util.*;

/**
 * 候选集
 */
public class Candidate {

    /**
     * 候选1项集
     * @param trans 事务集
     * @param min_sup 最小支持度
     * @param min_con 最小置信度
     * @return
     */
    public static Map<String, String> algorithm(List<AlgorithmData> trans, int min_sup, int min_con) {
        Set tran = new HashSet();
        for (AlgorithmData ad : trans){
            tran.add(ad.getS_Nm());
            tran.add(ad.getC_NO());
            tran.add(ad.getS_TO());
            tran.add(ad.getS_Indg());
            tran.add(ad.getS_Stha());
            tran.add(ad.getS_Hoco());
            tran.add(ad.getS_Ptim());
            tran.add(ad.getS_Un());
            tran.add(ad.getS_Ef());
        }

        Map<Object,Integer> counts = new HashMap<>();
        for (Object o: tran){
            int count = countTran(trans, o);
            counts.put(o,count);
        }
        return null;
    }

    public static int countTran(List<AlgorithmData> trans, Object tran){
        for (AlgorithmData ad : trans){
            if (ad.getS_Nm() == (int)tran){

            }
        }
        return 0;
    }

}
