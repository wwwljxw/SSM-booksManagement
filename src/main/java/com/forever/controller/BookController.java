package com.forever.controller;

import com.forever.domain.Book;
import com.forever.exception.BookException;
import com.forever.exception.TypeException;
import com.forever.service.BookService;
import com.forever.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

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
     * 修改书籍信息
     * @param book  要修改的书籍
     * @return  执行结果
     */
    @RequestMapping(value = "/updateBook" ,method=RequestMethod.POST)
    public AjaxResult updateBook(Book book){
        AjaxResult ajaxResult= null;
        try {
            bookService.updateBook(book);
        } catch (BookException e) {
            e.printStackTrace();
        }
        return ajaxResult;
    }
}
