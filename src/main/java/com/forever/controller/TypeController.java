package com.forever.controller;

import com.forever.exception.TypeException;
import com.forever.service.TypeService;
import com.forever.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    /**
     * 添加书籍分类
     * @param cname 要添加的分类
     * @return  执行结果
     */
    @RequestMapping(value = "/addBookType",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult addBookType(String cname){
        AjaxResult ajaxResult = null;
        try {
            ajaxResult = typeService.addType(cname);
        } catch (TypeException e) {
            e.printStackTrace();
        }
        return ajaxResult;
    }

    /**
     * 分页查询所有的书籍分类
     * @return  以json格式返回所有的书籍分类
     */
    @RequestMapping("/allBookType")
    @ResponseBody
    public Map pageAllTypeList(int page, int limit){
        return typeService.pageAllTypes(page,limit);
    }

    /**
     * 删除指定的书籍分类
     * @param cid  要删除的分类的cid
     * @return  执行结果
     */
    @RequestMapping(value = "/delBookType",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult delBookType(int cid){
        AjaxResult ajaxResult = null;
        try {
            ajaxResult = typeService.deleteType(cid);
        } catch (TypeException e) {
            e.printStackTrace();
        }

        return ajaxResult;
    }

    /**
     * 修改指定的书籍分类
     * @param cid  要修改的书籍分类的cid
     * @param cname 改好的cname
     * @return  执行结果
     */
    @RequestMapping(value = "/updateType",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult updateType(int cid,String cname){
        AjaxResult ajaxResult = null;
        try {
            ajaxResult = typeService.updateType(cid,cname);
        } catch (TypeException e) {
            e.printStackTrace();
        }
        return ajaxResult;
    }

}
