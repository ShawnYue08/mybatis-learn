package org.westos.mapper;

import org.westos.model.Account;

import java.util.List;

/**
 * @author lwj
 * @date 2020/9/5 14:00
 */
public interface AccountMapper {
    List<Account> queryAllAccount();

    Account queryByPrimaryId(Integer aid);

    Account queryAccountByName(String name);

    void insertAccount(Account account);

    void updateAccount(Account account);

    void deleteAccountById(Integer aid);
}
