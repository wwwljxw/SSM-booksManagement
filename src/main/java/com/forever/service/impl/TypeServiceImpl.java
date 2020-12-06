package com.forever.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.forever.dao.TypeMapper;

import com.forever.domain.Type;
import com.forever.exception.TypeException;
import com.forever.service.TypeService;
import com.forever.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    /**
     * 分页查询所有书籍类别
     * @param page 第几页
     * @param limit 每页要几条数据
     * @return  执行结果
     */
    @Override
    public Map pageAllTypes(int page, int limit) {
//        分页
        Page<Type> pageSize = new Page(page, limit);
        Page<Type> typePage = typeMapper.selectPage(pageSize, null);

//        封装sql分页后的执行结果
        Map<String, Object> types = new HashMap<>();
        types.put("code", 0);
        types.put("msg", "");
        types.put("count", typePage.getTotal());
        types.put("data", typePage.getRecords());
        return types;
    }

    /**
     * 添加书籍分类
     * @param cname 要添加的分类
     * @return 执行结果
     */
    @Override
    public AjaxResult addType(String cname) throws TypeException {
//        创建type对象用于接收书籍分类名
        Type type = new Type();
        type.setCname(cname);
//        执行sql语句
        int insert = typeMapper.insert(type);

//        封装sql执行结果
        AjaxResult ajaxResult = new AjaxResult();
        if (insert == 1) {
            ajaxResult.setSuccess(true);
            ajaxResult.setMessage("添加成功");
        } else {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("添加失败");
            throw new TypeException("添加书籍类别失败");
        }
        return ajaxResult;
    }

    /**
     * 删除指定的书籍分类
     * @param cid   要删除的书籍分类的cid
     * @return  执行结果
     */
    @Override
    public AjaxResult deleteType(int cid) throws TypeException {

        AjaxResult ajaxResult = new AjaxResult();
        int i = typeMapper.deleteById(cid);

        if (i == 1){
            ajaxResult.setSuccess(true);
            ajaxResult.setMessage("删除成功");
        }else{
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("删除失败");
            throw new TypeException("删除书籍类别失败");
        }
        return ajaxResult;
    }

    /**
     * 修改指定的书籍分类
     * @param cid   要修改的书籍分类的cid
     * @return  执行结果
     */
    @Override
    public AjaxResult updateType(int cid,String cname) throws TypeException {
        Type type = new Type();
        type.setCid(cid);
        type.setCname(cname);
//        执行sql语句
        int update = typeMapper.updateById(type);
//        封装sql执行结果
        AjaxResult ajaxResult = new AjaxResult();
        if (update == 1) {
            ajaxResult.setSuccess(true);
            ajaxResult.setMessage("修改成功");
        } else {
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("修改失败");
            throw new TypeException("修改书籍类别失败");
        }

        return ajaxResult;
    }

    @Override
    public List<Type> allType() {
        List<Type> types = typeMapper.selectList(null);
        return types;
    }
}
