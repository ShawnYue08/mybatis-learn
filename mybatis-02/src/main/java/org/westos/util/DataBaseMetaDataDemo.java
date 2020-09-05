package org.westos.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库元数据
 * @author lwj
 * @date 2020/9/5 10:44
 */
public class DataBaseMetaDataDemo {
    public void show() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///mybatis?useSSL=false",
                "root", "995995zxvc");
        DatabaseMetaData metaData = connection.getMetaData();
        //数据库元数据由Connection连接对象获取
        String databaseProductName = metaData.getDatabaseProductName();
        //数据库产品名称
        String databaseProductVersion = metaData.getDatabaseProductVersion();
        //数据库产品版本
        String driverName = metaData.getDriverName();
        //驱动名称
        String driverVersion = metaData.getDriverVersion();
        //驱动版本
        int defaultTransactionIsolation = metaData.getDefaultTransactionIsolation();
        //默认事务隔离级别
        System.out.println(databaseProductName);
        System.out.println(databaseProductVersion);
        System.out.println(driverName);
        System.out.println(driverVersion);
        System.out.println(defaultTransactionIsolation);
    }
}
