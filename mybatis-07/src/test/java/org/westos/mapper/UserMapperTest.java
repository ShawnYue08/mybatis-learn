package org.westos.mapper;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.westos.model.User;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lwj
 * @date 2020/9/20 12:52
 */
public class UserMapperTest {
    SqlSessionFactory factory = null;
    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testSelectByPrimaryKey() {
        try (SqlSession sqlSession = factory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectByPrimaryKey(1);
            System.out.println(JSON.toJSONString(user,true));
        }
    }
}
