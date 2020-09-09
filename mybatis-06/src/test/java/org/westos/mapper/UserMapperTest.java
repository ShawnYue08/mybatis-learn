package org.westos.mapper;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.westos.model.User;
import org.westos.util.SqlSessionFactoryUtil;

import java.io.IOException;
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
            user.setUid(3);
            user.setUname("黄忠");
            user.setUnickname("汉升");
            mapper.updateUser(user);
            System.out.println(JSON.toJSONString(mapper.selectByPrimaryKey(3), true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
