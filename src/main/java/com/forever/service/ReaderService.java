package com.forever.service;

import com.forever.domain.Reader;
import com.forever.exception.ReaderException;
import com.forever.util.AjaxResult;

public interface ReaderService {

    AjaxResult addReader(Reader reader) throws ReaderException;
    AjaxResult updateReader(Reader reader) throws ReaderException;
}
