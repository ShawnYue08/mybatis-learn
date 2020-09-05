package org.westos.util;


import org.westos.model.Account;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ResultSet封装为Java对象
 * @author lwj
 * @date 2020/9/5 10:43
 */
public class ResultSetMetaDemo<T> {
    public List<T> transferToObject(Class<T> clazz, ResultSet resultSet) {
        List<T> list = null;
        try {
            if (resultSet != null) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                Method[] declaredMethods = clazz.getDeclaredMethods();
                while (resultSet.next()) {
                    T obj = clazz.newInstance();
                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                        Object object = resultSet.getObject(i);
                        String columnLabel = metaData.getColumnLabel(i);
                        for (Method declaredMethod : declaredMethods) {
                            if (declaredMethod.getName().toUpperCase().equals(("set" + columnLabel).toUpperCase())) {
                                declaredMethod.invoke(obj, object);
                            }
                        }
                    }
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(obj);
                }
            } else {
                return null;
            }
        } catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return list;
    }
}
