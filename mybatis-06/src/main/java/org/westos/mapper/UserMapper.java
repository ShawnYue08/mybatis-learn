package org.westos.mapper;

import org.apache.ibatis.annotations.Param;
import org.westos.model.User;
import java.util.*;

/**
 * @author lwj
 * @date 2020/9/9 13:21
 */
public interface UserMapper {
    //使用sql标签
    User selectByPrimaryKey(Integer uid);


    //根据条件查询
    //使用if标签
    List<User> selectAll(User user);

    //根据条件查询
    //使用where标签
    List<User> selectAll2(User user);

    //使用update标签
    void updateUser(User user);

    //使用trim标签
    List<User> selectAll3(User user);

    //使用trim标签
    void updateUser2(User user);

    //使用trim标签
    void insertUser(User user);


    //使用foreach标签
    List<User> select(List<Integer> list);
}
