package org.westos.mapper;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.westos.model.Page;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lwj
 * @date 2020/9/22 11:51
 */
public class PageMapperTest {
    private SqlSessionFactory factory;


    @Before
    public void before() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
    }

    @Test
    public void initData() {
        try (SqlSession sqlSession = factory.openSession()) {
            PageMapper mapper = sqlSession.getMapper(PageMapper.class);
            for (int i = 1; i <= 100; i++) {
                Page page = new Page();
                page.setPname("java" + i);
                page.setPcount(i);
                page.setPprice(i + 0.1);
                mapper.insertSelective(page);
            }
            sqlSession.commit();
        }
    }

    //全查测试
    @Test
    public void select1() {
        try (SqlSession sqlSession = factory.openSession()) {
            PageMapper mapper = sqlSession.getMapper(PageMapper.class);
            List<Page> select = mapper.select(null);
            System.out.println(JSON.toJSONString(select, true));
        }
    }

    //全查测试，带参数
    @Test
    public void select2() {
        try (SqlSession sqlSession = factory.openSession()) {
            PageMapper mapper = sqlSession.getMapper(PageMapper.class);
            Page page = new Page();
            page.setPname("java2");
            List<Page> select = mapper.select(page);
            System.out.println(select.size());
        }
    }

    //全查测试，带分页
    @Test
    public void select3() {
        try (SqlSession sqlSession = factory.openSession()) {
            PageMapper mapper = sqlSession.getMapper(PageMapper.class);
            //配置分页，需要两个参数：1、pageNum第几页 2、pageSize页的大小
            PageHelper.startPage(2, 10);
            //第二页，查10条
            //limit (pageNum-1)*size, size
            //limit 0,10
            //limit 10,10
            //limit 20,10
            List<Page> select = mapper.select(null);
            System.out.println(select.size());
        }
    }

    //全查测试，带条件，带分页
    @Test
    public void select4() {
        try (SqlSession sqlSession = factory.openSession()) {
            PageMapper mapper = sqlSession.getMapper(PageMapper.class);
            PageHelper.startPage(1, 5);
            Page page = new Page();
            page.setPname("java1");
            List<Page> select = mapper.select(page);
            System.out.println(JSON.toJSONString(select, true));

            PageHelper.startPage(2, 5);
            select = mapper.select(page);
            System.out.println(JSON.toJSONString(select, true));
        }
    }

    //全查测试，带分页，带分页数据的封装功能
    @Test
    public void select5() {
        try (SqlSession sqlSession = factory.openSession()) {
            PageMapper mapper = sqlSession.getMapper(PageMapper.class);
            //在查询之前
            PageHelper.startPage(1, 10);
            List<Page> select = mapper.select(null);
            //分页信息封装类，通常写在封装之下
            PageInfo<Page> pageInfo = new PageInfo<>(select);
            System.out.println(JSON.toJSONString(pageInfo, true));
        }
    }
}
