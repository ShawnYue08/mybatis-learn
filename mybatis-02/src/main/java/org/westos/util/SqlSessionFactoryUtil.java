package org.westos.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author lwj
 * @date 2020/9/5 14:06
 */
public class SqlSessionFactoryUtil {
    private volatile static SqlSessionFactory sqlSessionFactory;

    private SqlSessionFactoryUtil() {

    }
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        if (sqlSessionFactory == null) {
            synchronized (SqlSessionFactoryUtil.class) {
                if (sqlSessionFactory == null) {
                    sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
                }
            }
        }
        return sqlSessionFactory;
    }
}
