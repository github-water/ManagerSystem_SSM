package com.water.ssm.service;


import com.water.ssm.domain.Role;
import com.water.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息业务层接口
 */
public interface IUserService extends UserDetailsService {

    /**
     * 查询所有用户信息
     */
    public List<UserInfo> findAll() throws Exception;

    /**
     * 保存新的用户
     * @param userInfo
     */
    void save(UserInfo userInfo) throws Exception;

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    UserInfo findById(String userId) throws Exception;

    List<Role> findOtherRoles(String userId);

    void addRoleToUser(String userId, String[] roleIds);
}
