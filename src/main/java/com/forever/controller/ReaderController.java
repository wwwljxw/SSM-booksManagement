package com.forever.controller;

import com.forever.domain.Reader;
import com.forever.exception.ReaderException;
import com.forever.service.ReaderService;
import com.forever.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    /**
     * 添加读者
     * @param reader    要添加的读者的信息
     * @return  sql执行结果
     */
    @RequestMapping(value = "/addReader",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult addReader(Reader reader){

        AjaxResult ajaxResult = null;
        try {
            ajaxResult = readerService.addReader(reader);
        } catch (ReaderException e) {
            e.printStackTrace();
        }
        return ajaxResult;
    }

    /**
     * 修改读者信息
     * @param reader 已i需改好的读者信息
     * @return  sql执行结果
     */
    @RequestMapping(value = "/updateReader",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult updateReader(Reader reader){
        AjaxResult ajaxResult = null;
        try {
            ajaxResult = readerService.updateReader(reader);
        } catch (ReaderException e) {
            e.printStackTrace();
        }

        return ajaxResult;
    }
}
