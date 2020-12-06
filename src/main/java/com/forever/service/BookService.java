package com.forever.service;

import com.forever.domain.Book;
import com.forever.exception.BookException;

import com.forever.util.AjaxResult;

import java.util.Map;

public interface BookService {

    Map pageAllBook(int page, int limit);


    AjaxResult submitAddBook(Book book) throws BookException;

    AjaxResult updateBook(Book book) throws BookException;

    Book selectBookById(Integer id);

    AjaxResult deleteBookById(Integer id) throws BookException;

}
