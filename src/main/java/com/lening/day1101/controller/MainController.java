package com.lening.day1101.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
    @RequestMapping("/index")
    public String index() {
        return "trainee_list";
    }
    @RequestMapping("/addtrainee")
    public String addorder() {
        return "add_list";
    }
}
