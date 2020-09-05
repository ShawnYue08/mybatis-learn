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
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\XiBuKaiYuan\\SSM\\mybatis\\mybatis-02\\target\\classes\\org\\westos\\service");

        ProxyCGLibUtil proxyCGLibUtil = new ProxyCGLibUtil(new AccountService());
        AccountService accountService = (AccountService) proxyCGLibUtil.getProxy();
        System.out.println(accountService.getClass().getName());
        //org.westos.service.AccountService$$EnhancerByCGLIB$$f91ee6ca
        accountService.register(new Account());
        accountService.show();
        //这里是对目标类进行增强
        //AccountService要保存数据了
        //这里是对目标类进行增强
        //AccountService查询数据并展示
    }
}
