package org.westos.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis工具类为Mapper提供
 * @author lwj
 * @date 2020/9/3 19:43
 */
public class SqlSessionFactoryUtil {
    private volatile static SqlSessionFactory factory;
    //volatile，禁止指令重排序，主要是new对象的操作

    private static final String CONFIG_FILE_NAME = "mybatis-config.xml";

    private SqlSessionFactoryUtil() {

    }

    /**
     * 保证SqlSessionFactory是系统唯一的
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        if (factory == null) {
            synchronized (SqlSessionFactoryUtil.class) {
                if (factory == null) {
                    try {
                        InputStream in = Resources.getResourceAsStream(CONFIG_FILE_NAME);
                        factory = new SqlSessionFactoryBuilder().build(in);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return factory;
    }
}
