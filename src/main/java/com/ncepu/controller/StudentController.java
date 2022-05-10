package com.ncepu.controller;

import com.ncepu.bean.ST_Score;
import com.ncepu.bean.ST_Student;
import com.ncepu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/scoreSearch")
    public String scoreSearch(HttpServletRequest request, Model model){
        ST_Student student = (ST_Student) request.getSession().getAttribute("student");
        model.addAttribute("name",student.getS_Nam());
        getScore(request,model);
        return "student/scoreSearch.jsp";
    }

    @RequestMapping("/scoreMiner")
    public String scoreMiner(){
        return "student/scoreMiner.jsp";
    }

    @RequestMapping("/searchByCno")
    public String searchByCno(String cno,HttpServletRequest request,Model model){
        ST_Student student = (ST_Student) request.getSession().getAttribute("student");
        model.addAttribute("name",student.getS_Nam());
        if (cno.equals("")){
            getScore(request,model);
            return "student/scoreSearch.jsp";
        }else {
            int C_NO = Integer.parseInt(cno);
            List<ST_Score> scores = studentService.selectScoreByCno(C_NO, student.getS_Nm());
            model.addAttribute("scoreList",scores);
            return "student/scoreSearch.jsp";
        }

    }

    private void getScore(HttpServletRequest request,Model model){
        ST_Student student = (ST_Student) request.getSession().getAttribute("student");
        List<ST_Score> scores = studentService.selectScoreBySnm(student.getS_Nm());
        System.out.println(student);
        model.addAttribute("scoreList",scores);
    }
}
