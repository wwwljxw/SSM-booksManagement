package com.forever.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.forever.dao.BookMapper;
import com.forever.domain.Book;
import com.forever.exception.BookException;
import com.forever.service.BookService;
import com.forever.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Map pageAllBook(int page, int limit) {
        //        分页
        Page<Book> pageSize = new Page(page, limit);
        Page<Book> typePage = bookMapper.selectPage(pageSize, null);

//        封装sql分页后的执行结果
        Map<String, Object> books = new HashMap<>();
        books.put("code", 0);
        books.put("msg", "");
        books.put("count", typePage.getTotal());
        books.put("data", typePage.getRecords());
        return books;
    }

    @Override
    public AjaxResult submitAddBook(Book book) throws BookException {
        int insert = bookMapper.insert(book);
        AjaxResult ajaxResult = new AjaxResult();
        if (insert == 1) {
            ajaxResult.setSuccess(true);
            ajaxResult.setMessage("添加成功");
        } else {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("添加失败");
            throw new BookException("添加书籍失败");
        }
        return ajaxResult;
    }

    @Override
    public AjaxResult updateBook(Book book) throws BookException {
        int update = bookMapper.updateById(book);
        AjaxResult ajaxResult = new AjaxResult();
        if (update == 1) {
            ajaxResult.setSuccess(true);
            ajaxResult.setMessage("修改成功");
        } else {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("修改失败");
            throw new BookException("修改书籍失败");
        }
        return ajaxResult;
    }

    @Override
    public Book selectBookById(Integer id){
        Book book = bookMapper.selectById(id);

        return book;
    }

    @Override
    public AjaxResult deleteBookById(Integer id) throws BookException {
        int delete = bookMapper.deleteById(id);
        AjaxResult ajaxResult = new AjaxResult();
        if (delete == 1) {
            ajaxResult.setSuccess(true);
            ajaxResult.setMessage("删除成功");
        } else {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("删除失败");
            throw new BookException("删除书籍失败");
        }
        return ajaxResult;
    }


}
