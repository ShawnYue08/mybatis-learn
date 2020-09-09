package org.westos.mapper;

import org.westos.model.Boy;

/**
 * @author lwj
 * @date 2020/9/7 21:48
 */
public interface BoyMapper {
    //非延迟加载
    Boy selectByBid(Integer bid);

    //延迟加载
    Boy selectByPrimaryBid(Integer bid);
}
