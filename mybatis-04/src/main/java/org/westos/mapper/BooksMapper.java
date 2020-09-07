package org.westos.mapper;

import org.westos.model.Books;

/**
 * @author lwj
 * @date 2020/9/7 14:59
 */
public interface BooksMapper {
    //多表连接查询，不支持延迟加载
    Books selectByPrimaryKey(int bookid);

    //多表连接查询，支持延迟加载
    Books selectByPrimaryKey2(int bookid);
}
