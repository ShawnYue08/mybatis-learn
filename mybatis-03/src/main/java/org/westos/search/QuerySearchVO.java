package org.westos.search;

import lombok.Data;
import org.westos.model.Account;

/**
 * 查询条件的封装类
 * 因为查询条件来源于多个封装类
 * @author lwj
 * @date 2020/9/7 11:28
 */
@Data
public class QuerySearchVO {
    private Account account;
//    private Order order;
//    查询条件来自多个实体类
}
