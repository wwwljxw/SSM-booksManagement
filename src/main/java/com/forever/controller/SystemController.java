package com.forever.controller;


import com.forever.dao.TypeMapper;
import com.forever.domain.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private TypeMapper mapper;

    @RequestMapping("/login")
    public String login(){
        return "/book/bookType";
    }

    @RequestMapping("/addBook")
    public String addBook(Model model){
        List<Type> types = mapper.selectList(null);
        model.addAttribute("type", types);
        return "/book/addBook";
    }

    @RequestMapping("/addReader")
    public String addReader(){
        return "/reader/addReader";
    }
}