package com.ncepu.controller;

import com.ncepu.bean.ST_Student;
import com.ncepu.bean.TE_Teacher;
import com.ncepu.service.StudentService;
import com.ncepu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/logindispatch")
    public String login(String user, Model model, HttpServletRequest request, HttpServletResponse response){
        //学生学号开头是1
        if (user.substring(0, 1).equals("1")) {
            return StudentLogin(user,model,request);
        //教师职工号开头是2
        }else if (user.substring(0,1).equals("2")){
            return TeacherLogin(user,model,request);
        //管理员固定账号
        }else if (user.equals("admin")){
            return AdminLogin(user,model,request);
        //输入有误
        }else {
            model.addAttribute("message", "用户名错误");
            return "/index";
        }
    }

    public String StudentLogin(String user,Model model,HttpServletRequest request){
        ST_Student student = studentService.getStudentBySnm(Integer.parseInt(user));
        System.out.println("student:"+student);
        if (student != null){
            HttpSession session =request.getSession();
            session.setMaxInactiveInterval(3600);

            session.setAttribute("student", student);
            return "student/main.jsp";
        }else {
            model.addAttribute("message", "学号错误");
            return "../../index.jsp";
        }
    }

    public String TeacherLogin(String user,Model model,HttpServletRequest request){
        TE_Teacher teacher = teacherService.getTeacherByTno(Integer.parseInt(user));
        System.out.println("teacher:"+teacher);
        if (teacher != null){
            HttpSession session =request.getSession();
            session.setMaxInactiveInterval(3600);

            session.setAttribute("teacher", teacher);
            model.addAttribute("name",teacher.getT_Name());
            return "teacher/main.jsp";
        }else {
            model.addAttribute("message","教工号错误");
            return "../../index.jsp";
        }
    }

    public String AdminLogin(String user,Model model,HttpServletRequest request){
        //没做管理员，感觉功能和教师端差不太多
//        System.out.println(u);
//        if (u != null && u.getPassword().equals(password)){
//            HttpSession session =request.getSession();
//            session.setMaxInactiveInterval(3600);
//
//            session.setAttribute("user", u);
//            return "admin/main.jsp";
//        }else {
//            model.addAttribute("message","用户名错误");
//            return "../../index.jsp";
//        }
        return null;
    }
}
