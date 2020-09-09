package org.westos.mapper;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.westos.model.Girl;
import org.westos.util.SqlSessionFactoryUtil;
import org.westos.model.Boy;

import java.io.IOException;

/**
 * @author lwj
 * @date 2020/9/7 21:59
 */
public class OneToOneTest {
    @Test
    public void testBoyMapper() {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            BoyMapper mapper = sqlSession.getMapper(BoyMapper.class);
            Boy boy = mapper.selectByPrimaryBid(1);
            //System.out.println(JSON.toJSONString(boy, true));
            System.out.println(boy.getBid());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGirlMapper() {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            GirlMapper mapper = sqlSession.getMapper(GirlMapper.class);
            Girl girl = mapper.selectByPrimaryGid(2);
            System.out.println(JSON.toJSONString(girl, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
