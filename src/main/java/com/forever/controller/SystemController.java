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

    /**
     *  跳转到添加书籍页面
     */
    @RequestMapping("/addBook")
    public String addBook(Model model){
        List<Type> types = mapper.selectList(null);
        model.addAttribute("type", types);
        return "/book/addBook";
    }

    /**
     *  跳转到添加读者页面
     */
    @RequestMapping("/addReader")
    public String addReader(){
        return "/reader/addReader";
    }

    /**
     *  跳转到书籍管理系统首页
     */
    @RequestMapping("/index")
    public String getIndex(Model model){
        List<Type> types = mapper.selectList(null);
        model.addAttribute("type", types);
        return "/index";
    }
}