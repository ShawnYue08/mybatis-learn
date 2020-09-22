package org.westos.mapper;

import org.westos.model.Page;
import org.westos.model.User;

import java.util.List;

public interface PageMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Page record);

    int insertSelective(Page record);

    Page selectByPrimaryKey(Integer pid);

    //带查询条件的分页的查询方法
    List<Page> select(Page page);

    int updateByPrimaryKeySelective(Page record);

    int updateByPrimaryKey(Page record);
}