package org.westos.mapper;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.westos.model.Account;
import org.westos.search.QuerySearchVO;
import org.westos.util.SqlSessionFactoryUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lwj
 * @date 2020/9/7 9:11
 */
public class AccountMapperTest {
    //判断环境是否搭建好
    @Test
    public void testQueryAll() {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
            System.out.println(mapper.queryAllAccount().size());
            //6，表中只有6条数据
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*输入参数映射测试*/

    //测试
    @Test
    public void testSelect() {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
            int pageIndex = 1;
            int pageSize = 3;
            List<Account> list = mapper.select((pageIndex - 1) * pageSize, pageSize);
            System.out.println(JSON.toJSONString(list, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectByMap() {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
            int pageIndex = 1;
            int pageSize = 3;
            Map<String,Object> map = new HashMap<>();
            map.put("startNo", (pageIndex - 1) * pageSize);
            map.put("pageSize", pageSize);
            List<Account> list = mapper.selectByMap(map);
            System.out.println(JSON.toJSONString(list, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectByVO() {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
            Account account = new Account();
            account.setAname("zhangsan");
            QuerySearchVO querySearchVO = new QuerySearchVO();
            querySearchVO.setAccount(account);
            List<Account> list = mapper.selectByQuerySearchVO(querySearchVO);
            System.out.println(JSON.toJSONString(list, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
            Account account = new Account();
            account.setAname("zhaoliu");
            account.setApassword("uiloahz");
            account.setAnickname("赵六");
            mapper.insertAccount(account);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*输出参数映射测试*/
    @Test
    public void testQuery() {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
            Map<String, Object> map = mapper.query(1);
            System.out.println(JSON.toJSONString(map, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQuery2() {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
            Map<String, Account> map = mapper.query2(1);
            System.out.println(JSON.toJSONString(map, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*resultMap测试*/
    @Test
    public void testSelectByPrimaryKey() {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
            Account account = mapper.selectByPrimaryKey(1);
            System.out.println(JSON.toJSONString(account, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*mapUnderscoreToCamelCase*/
    @Test
    public void testSelectByPrimaryId() {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
            Account account = mapper.selectByPrimaryId(1);
            System.out.println(JSON.toJSONString(account, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
