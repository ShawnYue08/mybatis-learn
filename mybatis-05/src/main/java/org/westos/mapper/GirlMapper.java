package org.westos.mapper;

import org.westos.model.Girl;

/**
 * @author lwj
 * @date 2020/9/7 21:48
 */
public interface GirlMapper {
    Girl selectByGid(Integer gid);

    Girl selectByPrimaryGid(Integer gid);
}
