package com.forever.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class SystemController {

    @RequestMapping("/login")
    public String login(){
        return "/system/index";
    }
}