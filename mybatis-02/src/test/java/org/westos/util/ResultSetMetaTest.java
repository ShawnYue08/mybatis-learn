package org.westos.util;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.westos.model.Account;

import java.sql.*;
import java.util.List;

/**
 * @author lwj
 * @date 2020/9/5 10:55
 */
public class ResultSetMetaTest {
    @Test
    public void test() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///mybatis?useSSL=false", "root", "995995zxvc");
        PreparedStatement preparedStatement = connection.prepareStatement("select aid, aname, apassword, a_nickname aickname from account");
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Account> list = new ResultSetMetaDemo<Account>().transferToObject(Account.class, resultSet);
        //System.out.println(list); 原生List输出显示效果不好，这里使用Fastjson输出
        //首先导入依赖
        System.out.println(JSON.toJSONString(list, true));
        //JSON.toJSONString(Object obj, boolean prettyFormat) 美化格式
    }
}
