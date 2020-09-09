package org.westos.mapper;

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

    void updateUser(User user);
}
