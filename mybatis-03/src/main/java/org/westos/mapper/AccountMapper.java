package org.westos.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.westos.model.Account;
import org.westos.search.QuerySearchVO;

import java.util.List;
import java.util.Map;

/**
 * @author lwj
 * @date 2020/9/5 14:00
 */
public interface AccountMapper {
    List<Account> queryAllAccount();

    //从第几条数据开始，查pageSize条数据，因为如果按页查询，需要 (pageIndex - 1) * pageSize
    List<Account> select(@Param("startNo") Integer startNo, @Param("pageSize") Integer pageSize);

    /**
     * 当使用Map作为参数时，必须要写方法的注释（传递的参数）
     * @param map startNo 从第几条数据开始，pageSize 每页的大小
     * @return
     */
    List<Account> selectByMap(Map<String,Object> map);

    /**
     * 当查询的条件来自多个model实体类时，可以使用@Param，可以使用Map封装，也可以使用下面的这种方式，VO封装
     * @param vo
     * @return
     */
    List<Account> selectByQuerySearchVO(QuerySearchVO vo);

    void insertAccount(Account account);

    /**
     * 返回值类型为Map
     * @param aid
     * @return
     */
    Map<String,Object> query(int aid);

    @MapKey("aname")
    Map<String,Account> query2(int aid);

    Account selectByPrimaryKey(Integer aid);

    /*mapUnderscoreToCamelCase*/
    Account selectByPrimaryId(int aid);
}
