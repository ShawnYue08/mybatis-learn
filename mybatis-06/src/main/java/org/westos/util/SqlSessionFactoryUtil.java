package org.westos.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lwj
 * @date 2020/9/7 22:00
 */
public class SqlSessionFactoryUtil {
    private static volatile SqlSessionFactory factory;

    private SqlSessionFactoryUtil() {

    }

    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        if (factory == null) {
            synchronized (SqlSessionFactoryUtil.class) {
                if (factory == null) {
                    InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
                    factory = new SqlSessionFactoryBuilder().build(in);
                }
            }
        }
        return factory;
    }
}
