package com.forever.controller;

import com.alibaba.fastjson.JSONObject;
import com.forever.domain.Type;
import com.forever.service.TypeService;
import com.forever.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

//    @PostMapping("/addBookType")
//    @ResponseBody
//    public int addBookType(String cname){
//        int i = typeService.addType(cname);
//        System.out.println(i);
//        return i;


    //添加加图书类别
    @RequestMapping(value = "/addBookType",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult addBookType(String cname) {
        AjaxResult ajaxResult = new AjaxResult();
        try{
            typeService.addType(cname);
            ajaxResult.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("添加失败");
        }
        return ajaxResult;
    }

    //图书分类异步请求
    @RequestMapping(value = "/allBookType",method = RequestMethod.POST)
    @ResponseBody
    public String listCategory() {
        List<Type> categorylist= typeService.allTypes();
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",categorylist.size());
        obj.put("data", categorylist);
        return obj.toString();
    }

}
