package org.westos.service;

import org.westos.model.Account;

/**
 * @author lwj
 * @date 2020/9/7 8:14
 */
public interface IAccountService {
    void register(Account account);

    void show();
}
