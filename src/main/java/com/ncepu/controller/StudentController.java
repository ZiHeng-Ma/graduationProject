package com.ncepu.controller;

import com.ncepu.bean.ST_Student;
import com.ncepu.service.StudentService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    private StudentService service;

    public List<ST_Student> getAll(){
        return service.getAll();
    }

    public ST_Student getStudentByNo(Integer no){
        return service.getStudentByNo(no);
    }
}
