package org.westos.service;

import org.westos.model.Account;

/**
 * @author lwj
 * @date 2020/9/5 17:39
 */
public class AccountService implements IAccountService{
    @Override
    public void register(Account account) {
        System.out.println("AccountService要保存数据了");
    }

    @Override
    public void show() {
        System.out.println("AccountService查询数据并展示");
    }
}
