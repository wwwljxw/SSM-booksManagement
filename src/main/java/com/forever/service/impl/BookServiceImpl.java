package com.forever.service.impl;

import com.forever.dao.BookMapper;
import com.forever.domain.Book;
import com.forever.exception.BookException;
import com.forever.service.BookService;
import com.forever.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

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


}
