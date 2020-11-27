package com.forever.dao;

import com.forever.domain.Books;

import java.util.List;


public interface BookMapper {

    /**
     * 增加一本书
     * @param book 书籍
     * @return 执行结果
     */
    int addBook(Books book);

    /**
     * 删除一本书
     * @param id 要删除的那本书的编号
     * @return 执行结果
     */
    int deleteBookById(int id);

    /**
     * 更新一本书的信息
     * @param book 更新后的书籍
     * @return 执行结果
     */
    int updateBook(Books book);

    /**
     * 查询一本书
     * @param id 要查询的书籍的编号
     * @return 查询到的书籍
     */
    Books selectBookById(int id);

    /**
     * 查询所有书
     * @return 执行结果
     */
    List<Books> selectBooks();
}
