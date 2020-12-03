package com.forever.service.impl;

import com.forever.dao.ReaderMapper;
import com.forever.domain.Reader;
import com.forever.exception.BookException;
import com.forever.exception.ReaderException;
import com.forever.service.ReaderService;
import com.forever.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderMapper readerMapper;

    @Override
    public AjaxResult addReader(Reader reader) throws ReaderException {
        int insert = readerMapper.insert(reader);

        AjaxResult ajaxResult = new AjaxResult();
        if (insert == 1) {
            ajaxResult.setSuccess(true);
            ajaxResult.setMessage("添加成功");
        } else {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("添加失败");
            throw new ReaderException("添加读者失败");
        }
        return ajaxResult;
    }

    @Override
    public AjaxResult updateReader(Reader reader) throws ReaderException {
        int update = readerMapper.updateById(reader);
        AjaxResult ajaxResult = new AjaxResult();
        if (update == 1) {
            ajaxResult.setSuccess(true);
            ajaxResult.setMessage("修改成功");
        } else {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("修改失败");
            throw new ReaderException("修改读者资料失败");
        }
        return ajaxResult;
    }
}
