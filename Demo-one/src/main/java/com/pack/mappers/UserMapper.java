package com.pack.mappers;

import com.pack.entity.User;

/**
 * @author 娃哈哈
 * mapper接口
 */
public interface UserMapper {
    /**
     * 通过用户名查询该用户的相关信息
     * @param id
     * @return
     * @throws Exception
     */
    User selectObject(Integer id)throws Exception;
}
