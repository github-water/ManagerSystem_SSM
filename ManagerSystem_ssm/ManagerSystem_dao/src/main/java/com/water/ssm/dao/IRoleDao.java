package com.water.ssm.dao;

import com.water.ssm.domain.Permission;
import com.water.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色操作Dao
 */
@Repository
public interface IRoleDao {

    /**
     * 根据userId查询角色信息
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id=true, column = "id", property = "id"),
            @Result( column = "roleName", property = "roleName"),
            @Result( column = "roleDesc", property = "roleDesc"),
            @Result( column = "id", property = "permissions", javaType = java.util.List.class, many = @Many(select = "com.water.ssm.dao.IPermissionDao.findByRoleId"))

    })
    public List<Role> findRolesByUserId(String userId) throws Exception;


    /**
     * 查询所有角色信息
     * @return
     */
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role values(uuid(),#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    /**
     * 根据角色id查询角色
     * @param roleId
     * @return
     */
    @Select("select * from role where id=#{roleId}")
    Role findById(String roleId);


    /**
     * 根据角色id查询可添加权限
     * @param roleId
     * @return
     */
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissionById(String roleId);

    @Insert("insert into role_permission values(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
