package org.westos.mapper;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.westos.model.User;
import org.westos.util.SqlSessionFactoryUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lwj
 * @date 2020/9/9 13:27
 */
public class UserMapperTest {
    @Test
    public void test() {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUid(1);
            User user1 = mapper.select2(user);
            System.out.println(JSON.toJSONString(user1, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
