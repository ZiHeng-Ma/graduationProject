package com.ncepu.core;

import com.ncepu.bean.ST_Intrest;
import com.ncepu.bean.ST_Score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 算法主类
 */
public class AlgorithmMain {

    /**
     * 传过来的map数据格式复杂，有无用数据，将map集合中有需要的内容提取出来，生成事务集
     * @param param 所有的的数据map
     * @param min_sup 最小支持度
     * @param min_con 最小置信度
     * @return
     */
    public Map<String,String> algorithmMain(Map<ST_Intrest,List<Integer>> param,int min_sup, double min_con){
        List<String> aprioriList = null;
        for (Map.Entry<ST_Intrest,List<Integer>> entry : param.entrySet()){
            ST_Intrest intrest = entry.getKey();
            List<Integer> scores = entry.getValue();

//            int S_Nm = score.getS_Nm();
//            snmIndex.add(S_Nm);
            aprioriList = new ArrayList<>();

            for (Integer score : scores) {

                String S_TO = changeSTO(score);
                String s_indg = intrest.getS_Indg();
                String s_stha = intrest.getS_Stha();
                String s_hoco = intrest.getS_Hoco();
                String s_ptim = intrest.getS_Ptim();
                String s_un = intrest.getS_Un();
                String s_ef = intrest.getS_Ef();
                aprioriList.add(String.format("%S、%S、%S、%S、%S、%S、%S", S_TO, s_indg, s_stha, s_hoco, s_ptim, s_un, s_ef));
            }
//            result.put(S_Nm,aprioriList);
//            test(aprioriList,min_sup,min_con);
            for (String str : aprioriList){
                System.out.println(str);
            }
            System.out.println("======================================");
        }


        return null;
    }

    /**
     * 成绩变等级
     */
    private String changeSTO(int S_TO){
        if (S_TO >= 90)
            return "A";
        else if (S_TO >= 75)
            return "B";
        else if (S_TO >= 60)
            return "C";
        else
            return "D";
    }

    public Map<ST_Intrest, List<Integer>> initMap(List<ST_Score> scores, List<ST_Intrest> intrests, Map<ST_Intrest,List<Integer>> result){
        List<Integer> list = null;
        for (ST_Intrest intrest : intrests){
            list = new ArrayList<>();
            for (ST_Score score : scores) {
                if (score.getS_Nm() == intrest.getS_Nm()){
                    list.add(score.getS_TO());
                }
            }
            System.out.println(intrest.getS_Nm() +":"+ list);
            result.put(intrest,list);
        }
        return result;
    }

    private void test(List<String> aprioriList,int min_sup,double min_con){
        Apriori apriori = new Apriori(aprioriList,min_sup,min_con);
        Map<List<String>,Integer> frequentCollectionMap = apriori.getFC();
        System.out.println("-------------频繁集"+"----------------");
        for(List<String> list : frequentCollectionMap.keySet()) System.out.println(list+ "\t"+ frequentCollectionMap.get(list));

        Map<String,Double> relationRulesMap = apriori.getRelationRules(frequentCollectionMap);
        System.out.println("-----------关联规则"+"----------------");
        for (String s : relationRulesMap.keySet()) System.out.println(s+"\t"+relationRulesMap.get(s));
    }
}
