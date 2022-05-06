package com.ncepu.controller;

import com.ncepu.bean.ST_Score;
import com.ncepu.bean.TE_Teacher;
import com.ncepu.service.TeacherService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/function")
public class TeacherFunctionController {
    
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/dataInAndOut")
    public String DataInAndOut(){
        return "teacher/dataInAndOut.jsp";
    }

    @RequestMapping("/scoreManager")
    public String ScoreManager(HttpServletRequest request, Model model){
        getScore(request, model);
        return "teacher/scoreManager.jsp";
    }

    @RequestMapping("/scoreSearch")
    public String ScoreSearch(){
        return "teacher/scoreSearch.jsp";
    }

    @RequestMapping("/scoreMiner")
    public String ScoreMiner(){
        return "teacher/scoreMiner.jsp";
    }

    @RequestMapping("/scoreStatistic")
    public String ScoreStatistic(){
        return "teacher/scoreStatistic.jsp";
    }

    @RequestMapping("/updateOneData")
    public String updateOneData(HttpServletRequest request, Model model, @RequestParam String c_no){
        request.getSession().setAttribute("c_no",c_no);
        return "teacher/scoreManger_updateOneData.jsp";
    }

    @RequestMapping("/submitOneData")
    public String submitOneData(Model model,HttpServletRequest request,
                                String Input1,String Input2,String Input3,String Input4,String Input5){
        TE_Teacher teacher = (TE_Teacher)request.getSession().getAttribute("teacher");
        int c_no = Integer.parseInt((String) request.getSession().getAttribute("c_no"));
        System.out.println(c_no + " " + Input1 + " " + Input2 + " " + Input3 + " " + Input4);
        int S_Ncor = Integer.parseInt(Input1);
        int S_Mid = Integer.parseInt(Input2);
        int S_Fs = Integer.parseInt(Input3);
        int S_TO = Integer.parseInt(Input4);
        int S_Nm = Integer.parseInt(Input5);
        teacherService.updateOneData(teacher.getT_No(),S_Nm,c_no,S_Ncor,S_Mid,S_Fs,S_TO);
        model.addAttribute("update","修改成功");
        return "forward:scoreManager";
    }

    @RequestMapping("/deleteOneData")
    public String deleteOneData(Model model, HttpServletRequest request, @RequestParam String c_no){
        TE_Teacher teacher = (TE_Teacher) request.getSession().getAttribute("teacher");
        teacherService.deleteOneData(teacher.getT_No(),Integer.parseInt(c_no));
        model.addAttribute("update","删除成功");
        return "forward:scoreManager";
    }

    @RequestMapping("/addOneData")
    public String addOneData(){return "teacher/scoreManager_add.jsp";}

    @RequestMapping("/insertOneData")
    public String insertOneData(Model model,HttpServletRequest request,
                                String Input5,String Input1,String Input2,String Input3,String Input4,String Input6){
        TE_Teacher teacher = (TE_Teacher) request.getSession().getAttribute("teacher");
        int T_No = teacher.getT_No();
        int S_Nm = Integer.parseInt(Input5);
        int C_NO = Integer.parseInt(Input6);
        int S_Ncor = Integer.parseInt(Input1);
        int S_Mid = Integer.parseInt(Input2);
        int S_Fs = Integer.parseInt(Input3);
        int S_TO = Integer.parseInt(Input4);
        teacherService.insertOneData(T_No,S_Nm,C_NO,S_Ncor,S_Mid,S_Fs,S_TO);
        model.addAttribute("update","添加成功");
        return "forward:scoreManager";
    }

    public void getScore(HttpServletRequest request, Model model){
        TE_Teacher teacher = (TE_Teacher) request.getSession().getAttribute("teacher");
        model.addAttribute("name",teacher.getT_Name());
        List<ST_Score> te_teachers = teacherService.selectScoreByTno(teacher.getT_No());
        System.out.println(te_teachers);
        model.addAttribute("scoreList", te_teachers);
    }
}
