package com.forever.service;

import com.forever.domain.Book;
import com.forever.exception.BookException;

import com.forever.util.AjaxResult;

public interface BookService {
    AjaxResult submitAddBook(Book book) throws BookException;

    AjaxResult updateBook(Book book) throws BookException;

}
