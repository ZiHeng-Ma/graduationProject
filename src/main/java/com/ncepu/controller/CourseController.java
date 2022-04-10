package com.ncepu.controller;

import com.ncepu.bean.ST_Course;
import com.ncepu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping("")
    public String getCourse(Model model){
        List<ST_Course> result = service.getCourse();
        model.addAttribute("course", result);
        return "index";
    }
}
