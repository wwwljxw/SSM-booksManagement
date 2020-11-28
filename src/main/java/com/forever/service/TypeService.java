package com.forever.service;

import com.forever.domain.Type;

import java.util.List;

public interface TypeService {
    /**
     * 查询所有书籍类型
     * @return  所有的书籍类型
     */
    List<Type> allTypes();

    /**
     * 添加新的书籍类型
     * @param cname 新的书籍类型名称
     * @return  执行结果
     */
    int addType(String cname);

    /**
     * 删除书籍类型
     * @param cid   要删除的书籍类型的编号
     * @return  执行结果
     */
    int deleteType(int cid);
}
