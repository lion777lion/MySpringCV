package com.lion.cv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping
    @RequestMapping("index")
    public String Index(){
        return ("index");
    }



    @GetMapping
    @RequestMapping("contact")
    public String Contact(){
        return ("contact");
    }
}
