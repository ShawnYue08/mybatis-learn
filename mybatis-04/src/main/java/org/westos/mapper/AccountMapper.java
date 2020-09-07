package org.westos.mapper;

import org.westos.model.Account;

/**
 * @author lwj
 * @date 2020/9/7 16:03
 */
public interface AccountMapper {
    Account selectById(Integer aid);


    //延迟加载
    Account selectByPrimary(Integer aid);
}
