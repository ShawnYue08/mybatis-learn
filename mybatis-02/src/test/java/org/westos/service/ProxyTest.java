package org.westos.service;

import org.junit.Test;

/**
 * @author lwj
 * @date 2020/9/7 8:16
 */
public class ProxyTest {
    @Test
    public void testProxy() {
        AccountService accountService = new AccountService();
        IAccountService service = (IAccountService) new ProxyUtil(accountService).getProxy();
        service.register(null);
        service.show();
        //===2020-09-07 08:21:06正在访问public abstract void org.westos.service.IAccountService.register(org.westos.model.Account)===
        //AccountService要保存数据了
        //程序耗时0s.
        //===2020-09-07 08:21:06正在访问public abstract void org.westos.service.IAccountService.show()===
        //AccountService查询数据并展示
        //程序耗时0s.
    }
}
