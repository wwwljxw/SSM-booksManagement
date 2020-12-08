package com.forever.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.forever.dao.ReaderMapper;
import com.forever.domain.Reader;
import com.forever.exception.ReaderException;
import com.forever.service.ReaderService;
import com.forever.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            ajaxResult.setMessage("注册成功");
        } else {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("注册失败");
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

    @Override
    public Map pageAllReader(int page, int limit) {
        //        分页
        Page<Reader> pageSize = new Page(page, limit);
        Page<Reader> typePage = readerMapper.selectPage(pageSize, null);

//        封装sql分页后的执行结果
        Map<String, Object> books = new HashMap<>();
        books.put("code", 0);
        books.put("msg", "");
        books.put("count", typePage.getTotal());
        books.put("data", typePage.getRecords());
        return books;
    }

    @Override
    public AjaxResult checkReader(Integer reader_id){
        Integer checkReader = readerMapper.selectCount(new QueryWrapper<Reader>().eq("reader_id",reader_id));
        AjaxResult ajaxResult = new AjaxResult();

        if (checkReader == 1) {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("借阅号已被注册，请重新输入！");
        } else {
            ajaxResult.setSuccess(true);
            ajaxResult.setMessage("该借阅号可以注册！");
        }
        return ajaxResult;
    }

    @Override
    public Reader selectById(Integer id) {
        return readerMapper.selectById(id);
    }

    @Override
    public AjaxResult deleteById(Integer id) throws ReaderException {
        QueryWrapper<Reader> reader_id = new QueryWrapper<Reader>().eq("reader_id", id);
        int delete = readerMapper.delete(reader_id);
        AjaxResult ajaxResult = new AjaxResult();
        if (delete == 1) {
            ajaxResult.setSuccess(true);
            ajaxResult.setMessage("删除成功");
        } else {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("删除失败");
            throw new ReaderException("删除读者失败");
        }
        return ajaxResult;
    }
}
