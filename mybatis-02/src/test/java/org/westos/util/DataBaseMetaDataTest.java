package org.westos.util;

import org.junit.Test;

import java.sql.SQLException;

/**
 * @author lwj
 * @date 2020/9/5 11:46
 */
public class DataBaseMetaDataTest {
    @Test
    public void test() throws SQLException, ClassNotFoundException {
        DataBaseMetaDataDemo dataBaseMetaDataDemo = new DataBaseMetaDataDemo();
        dataBaseMetaDataDemo.show();
    }
}
