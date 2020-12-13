package com.forever.service;

import com.forever.domain.Reader;
import com.forever.exception.ReaderException;
import com.forever.util.AjaxResult;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ReaderService {

    AjaxResult addReader(Reader reader) throws ReaderException;
    AjaxResult updateReader(Reader reader) throws ReaderException;
    Map pageAllReader(int page, int limit);
    AjaxResult checkReader(Integer reader_id);
    Reader selectById(Integer id);
    AjaxResult deleteById(Integer id) throws ReaderException;
    Reader doLogin(String name,String password);
}
