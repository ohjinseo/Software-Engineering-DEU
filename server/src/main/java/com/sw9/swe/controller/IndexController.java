package com.sw9.swe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/addSubject")
    public String addSubject() {
        return "addSubject";
    }

    @GetMapping("/addStudent")
    public String addStudent() {
        return "addStudent";
    }

    @GetMapping("/studentList")
    public String studentList() {
        return "studentList";
    }

    @GetMapping("/subjectList")
    public String subjectList() {
        return "subjectList";
    }
}
