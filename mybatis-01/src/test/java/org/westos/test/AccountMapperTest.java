package org.westos.test;

import org.junit.Before;
import org.junit.Test;
import org.westos.mapper.AccountMapper;
import org.westos.model.Account;

import java.util.List;

/**
 * @author lwj
 * @date 2020/9/3 20:24
 */
public class AccountMapperTest {
    private AccountMapper accountMapper;

    @Before
    public void before() {
        accountMapper = new AccountMapper();
    }

    @Test
    public void queryAll() {
        //1、查询全部
        List<Account> list = accountMapper.queryAll();
        System.out.println(list);
        //[Account(aid=1, aname=zhangsan, apassword=nasgnahz, anickname=张三), Account(aid=2, aname=lisi, apassword=isil, anickname=李四)]
    }

    @Test
    public void insert() {
        //2、插入一条记录
        Account account = new Account();
        account.setAname("kenny");
        account.setApassword("123456");
        account.setAnickname("kk");
        accountMapper.insert(account);
        System.out.println(account.getAname());
        //cef4cf5e-ee6b-11ea-8661-98fa9b26cec1
    }

    @Test
    public void queryOne() {
        //3、查询单条记录
        Account account = accountMapper.queryOne(2);
        System.out.println(account);
        //Account(aid=3, aname=wangwu, apassword=uwgnaw, anickname=王五)
    }

    @Test
    public void queryByName() {
        Account account = accountMapper.queryByName("lisi");
        System.out.println(account);
    }

    @Test
    public void selectByName() {
        //List<Account> list = accountMapper.selectByName("a' or 1 = 1 -- ");
        List<Account> list = accountMapper.selectByName("%zhang%");
        System.out.println(list);
    }

    @Test
    public void update() {
        //4、更新数据
        Account account = new Account();
        account.setAid(3);
        account.setAname("zhaoliu");
        account.setApassword("uiloahz");
        account.setAnickname("赵六");
        accountMapper.update(account);
    }

    @Test
    public void delete() {
        //5、删除记录
        accountMapper.delete(3);
    }
}
