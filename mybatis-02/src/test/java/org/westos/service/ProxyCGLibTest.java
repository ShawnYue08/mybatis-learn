package org.westos.service;

import net.sf.cglib.core.DebuggingClassWriter;
import org.junit.Test;
import org.westos.model.Account;

/**
 * @author lwj
 * @date 2020/9/5 18:00
 */
public class ProxyCGLibTest {
    @Test
    public void test() {
        //在指定目录下生成动态代理类
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\XiBuKaiYuan\\SSM\\mybatis\\mybatis-02\\target\\classes\\org\\westos\\service");

        AccountService accountService = new AccountService();
        AccountService service = (AccountService) new ProxyCGLibUtil(accountService).getProxy();
        System.out.println(service);
        //org.westos.service.AccountService$$EnhancerByCGLIB$$f91ee6ca@33a10788
        service.register(new Account());
        service.show();
        //AccountService要保存数据了
        //AccountService查询数据并展示
    }
}
