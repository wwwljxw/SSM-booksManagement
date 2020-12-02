package com.forever.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.forever.domain.Type;
import com.forever.exception.TypeException;
import com.forever.service.TypeService;
import com.forever.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/type")
public class TypeController {

    @Resource
    private TypeService typeService;

    /**
     * 添加图书分类异步请求
     * @param cname 添加图书类别
     * @return  执行结果
     */
    @RequestMapping(value = "/addBookType",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult addBookType(String cname) throws TypeException {
        AjaxResult ajaxResult = new AjaxResult();
        int i = typeService.addType(cname);
        if(i ==1 ){
            ajaxResult.setSuccess(true);
            ajaxResult.setMessage("添加成功");
        }else {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("添加失败");
            throw new TypeException("书籍分类添加失败");
        }
        return ajaxResult;
    }

    /**
     * 图书分类异步请求
     * @return  查询所有的图书分类
     */
    @RequestMapping("/allBookType")
    @ResponseBody
    public String listCategory() {
        List<Type> booksList= typeService.allTypes();
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count", booksList.size());
        obj.put("data", booksList);
        return obj.toString();
    }

}
