package org.westos.mapper;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.westos.model.Account;
import org.westos.model.Books;
import org.westos.util.SqlSessionFactoryUtil;

import java.io.IOException;

/**
 * @author lwj
 * @date 2020/9/7 15:07
 */
public class BooksMapperTest {
    /*查询一对多多的一方*/
    @Test
    public void testSelectByPrimaryKey() {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            BooksMapper mapper = sqlSession.getMapper(BooksMapper.class);
            Books books = mapper.selectByPrimaryKey(1);
            System.out.println(JSON.toJSONString(books, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectByPrimaryKey2() {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            BooksMapper mapper = sqlSession.getMapper(BooksMapper.class);
            Books books = mapper.selectByPrimaryKey2(1);
            System.out.println(books);
            //延迟加载之后，拿到的books是一个代理对象
            System.out.println(books.getBookname());
            System.out.println(books.getAccount());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*查询一对多一的一方*/
    @Test
    public void testSelectById() {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
            Account account = mapper.selectById(1);
            System.out.println(JSON.toJSONString(account, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectByPrimary() {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
            Account account = mapper.selectByPrimary(1);
            System.out.println(account.getAname());
            System.out.println(JSON.toJSONString(account, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*延迟加载传递多个参数*/

}
