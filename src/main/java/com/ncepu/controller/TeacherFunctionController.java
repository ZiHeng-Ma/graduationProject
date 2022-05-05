package com.ncepu.controller;

import com.ncepu.bean.ST_Score;
import com.ncepu.bean.TE_Teacher;
import com.ncepu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String ScoreManager(){
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

    @RequestMapping("/getScore")
    public String getScore(HttpServletRequest request, Model model){
        TE_Teacher teacher = (TE_Teacher) request.getSession().getAttribute("teacher");
        List<ST_Score> te_teachers = teacherService.selectAllByTno(teacher.getT_No());
        model.addAttribute("scoreList", te_teachers);
        return "teacher/scoreManger_show.jsp";
    }
}
