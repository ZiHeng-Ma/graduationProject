package com.ncepu.controller;

import com.ncepu.bean.ST_Student;
import com.ncepu.bean.TE_Teacher;
import com.ncepu.service.StudentService;
import com.ncepu.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private StudentService sservice;
    private TeacherService tservice;

    @GetMapping("/loginStu")
    public String loginStu(){
        return "student/login";
    }

    @RequestMapping("/loginTea")
    public String loginTea(){
        return "teacher/login";
    }

    @PostMapping("/login/submit")
    public String login(Model model, @RequestParam("no")Integer no){
        //学生学号开头是1
        if (no.toString().substring(0, 1).equals("1")){
            ST_Student student = sservice.getStudentByNo(no);
            if (null != student)
                return "student/index";
            else
                model.addAttribute("no", "学号输入错误");
                return "student/login";
        //教师开头是2
        }else {
            TE_Teacher teacher = tservice.getTeacherByNo(no);
            if (null != teacher)
                return "teacher/index";
            else
                model.addAttribute("no", "教职工号输入错误");
            return "teacher/login";
        }
    }
}
