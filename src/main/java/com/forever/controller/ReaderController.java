package com.forever.controller;

import com.forever.domain.Book;
import com.forever.domain.Reader;
import com.forever.domain.Type;
import com.forever.exception.ReaderException;
import com.forever.service.ReaderService;
import com.forever.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    /**
     * 分页查询所有的读者
     * @return  以json格式返回所有的书籍
     */
    @RequestMapping("/pageAllBook")
    @ResponseBody
    public Map pageAllTypeList(int page, int limit){
        return readerService.pageAllReader(page,limit);
    }

    /**
     *  跳转到添加读者页面
     */
    @RequestMapping("/getAddReader")
    public String getAddBook(){

        return "/reader/addReader";
    }
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
     *  跳转到修改读者页面
     */
    @RequestMapping(value = "/getUpdateReader")
    public String getUpdateBook(Integer id, Model model){
        Reader reader = readerService.selectById(id);

        model.addAttribute("reader",reader);
        model.addAttribute("code",1);
        return "/reader/addReader";
    }

    /**
     * 修改读者信息
     * @param reader 已需改好的读者信息
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

    /**
     * 删除指定的读者
     * @param id    要删除的读者的id
     * @return  执行结果
     */
    @RequestMapping(value = "/delReader",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult deleteReaerById(Integer id){
        AjaxResult ajaxResult = null;
        try {
            ajaxResult = readerService.deleteById(id);
        } catch (ReaderException e) {
            e.printStackTrace();
        }
        return ajaxResult;
    }

    /**
     * 查看指定读者的信息
     */
    @RequestMapping(value = "/findReader")
    public String findReader(Integer id,Model model){
        Reader reader = readerService.selectById(id);
        model.addAttribute("reader",reader);
        return "/reader/addReader";
    }

    /**
     * 对比要注册的借阅号是否已被注册
     * @param readerId 要注册对比的借阅号
     * @return  对比结果
     */
    @RequestMapping(value = "/checkReader",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult checkReader(Integer readerId){
        return readerService.checkReader(readerId);
    }
}
