package org.westos.mapper;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.westos.model.Account;
import org.westos.util.SqlSessionFactoryUtil;

import java.io.IOException;
import java.util.List;

/**
 * @author lwj
 * @date 2020/9/5 14:04
 */
public class AccountMapperTest {
    @Test
    public void queryAll() throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        List<Account> list = mapper.queryAllAccount();
        System.out.println(JSON.toJSONString(list, true));
    }

    @Test
    public void queryByPrimaryId() throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        Account account = mapper.queryByPrimaryId(1);
        System.out.println(JSON.toJSONString(account, true));
    }

    //增删改
}
