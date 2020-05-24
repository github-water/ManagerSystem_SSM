package com.water.ssm.service;

import com.water.ssm.domain.Permission;
import com.water.ssm.domain.Role;

import java.util.List;

/**
 * 角色信息业务接口层
 */
public interface IRoleService {

    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId);

    List<Permission> findOtherPermissionById(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds);
}
