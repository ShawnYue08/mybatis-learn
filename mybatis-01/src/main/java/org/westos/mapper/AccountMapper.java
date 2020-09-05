package org.westos.mapper;

import org.apache.ibatis.session.SqlSession;
import org.westos.model.Account;
import org.westos.util.SqlSessionFactoryUtil;

import java.util.List;

/**
 * @author lwj
 * @date 2020/9/3 20:05
 */
public class AccountMapper {
    public List<Account> queryAll() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        try {
            return sqlSession.selectList("org.westos.mapper.AccountMapper.queryAll");
        } finally {
            sqlSession.close();
        }
    }

    public Account queryOne(Integer aid) {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            return sqlSession.selectOne("org.westos.mapper.AccountMapper.queryOne", aid);
        }
    }

    public Account queryByName(String name) {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            return sqlSession.selectOne("org.westos.mapper.AccountMapper.queryByName", name);
        }
    }

    //模糊查询
    public List<Account> selectByName(String name) {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            return sqlSession.selectList("org.westos.mapper.AccountMapper.selectByName1", name);
        }
    }

    public void insert(Account account) {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            sqlSession.insert("org.westos.mapper.AccountMapper.insert2", account);
            sqlSession.commit();
        }
    }

    public void update(Account account) {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            sqlSession.update("org.westos.mapper.AccountMapper.update", account);
            sqlSession.commit();
        }
    }

    public void delete(int aid) {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            sqlSession.delete("org.westos.mapper.AccountMapper.delete", aid);
            sqlSession.commit();
        }
    }
}
