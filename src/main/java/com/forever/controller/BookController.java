package com.forever.controller;

import com.forever.domain.Book;
import com.forever.domain.Type;
import com.forever.exception.BookException;
import com.forever.service.BookService;
import com.forever.service.TypeService;
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
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private TypeService typeService;

    /**
     *  跳转到添加书籍页面
     */
    @RequestMapping("/addBook")
    public String getAddBook(Model model){
        List<Type> types = typeService.allType();
        model.addAttribute("type", types);
        return "/book/addBook";
    }

    /**
     * 分页查询所有的书籍
     * @return  以json格式返回所有的书籍
     */
    @RequestMapping("/pageAllBook")
    @ResponseBody
    public Map pageAllTypeList(int page, int limit){
        return bookService.pageAllBook(page,limit);
    }

    /**
     * 添加书籍
     * @param book  要添加的书籍
     * @return  执行结果
     */
    @RequestMapping(value = "/submitAddBook",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult submitAddBook(Book book){
        AjaxResult ajaxResult = null;
        try {
            ajaxResult = bookService.submitAddBook(book);
        } catch (BookException e) {
            e.printStackTrace();
        }
        return ajaxResult;
    }

    /**
     *  跳转到修改书籍页面
     */
    @RequestMapping(value = "/getUpdateBook")
    public String getUpdateBook(Integer id, Model model){
        List<Type> types = typeService.allType();
        Book book = bookService.selectBookById(id);

        model.addAttribute("bookinfo",book);
        model.addAttribute("type", types);
        model.addAttribute("code",1);
        return "/book/addBook";
    }

    /**
     *  查看指定书籍信息
     */
    @RequestMapping(value = "/findBook")
    public String findBook(Integer id, Model model){
        List<Type> types = typeService.allType();
        Book book = bookService.selectBookById(id);
        model.addAttribute("type", types);
        model.addAttribute("bookinfo",book);

        return "/book/addBook";
    }

    /**
     * 修改书籍信息
     * @param book  要修改的书籍
     * @return  执行结果
     */
    @RequestMapping(value = "/updateBook" ,method=RequestMethod.POST)
    @ResponseBody
    public AjaxResult updateBook(Book book){
        AjaxResult ajaxResult= null;
        try {
            bookService.updateBook(book);
        } catch (BookException e) {
            e.printStackTrace();
        }
        return ajaxResult;
    }

    /**
     * 删除指定书籍
     * @param id    要删除的书籍的id
     * @return  执行结果
     */
    @RequestMapping(value = "/delBook",method=RequestMethod.POST)
    @ResponseBody
    public AjaxResult delBook(Integer id){
        AjaxResult ajaxResult= null;

        try {
            ajaxResult = bookService.deleteBookById(id);
        } catch (BookException e) {
            e.printStackTrace();
        }
        return ajaxResult;
    }
}
