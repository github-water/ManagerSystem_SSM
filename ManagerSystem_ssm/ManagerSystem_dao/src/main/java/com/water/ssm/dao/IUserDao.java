package com.water.ssm.dao;

import com.water.ssm.domain.Role;
import com.water.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户登录dao层接口
 */
@Repository
public interface IUserDao {

    /**
     * 根据用户名查询所有用户信息
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true,column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many = @Many(select = "com.water.ssm.dao.IRoleDao.findRolesByUserId")),

    })
    public UserInfo findByUsername(String username) throws Exception;


    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select * from users")
    public List<UserInfo> findAll() throws Exception;

    /**
     * 新增新用户信息
     * @param userInfo
     */
    @Insert("insert into users(id,email,username,password,phoneNum,status) value(uuid(),#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    @Select("select * from users where id=#{userId}")
    @Results({
            @Result(id = true,column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many = @Many(select = "com.water.ssm.dao.IRoleDao.findRolesByUserId"))
    })
    UserInfo findById(String userId);


    @Select("select * from users where id=#{userId}")
    @Results({
            @Result(id = true,column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many = @Many(select = "com.water.ssm.dao.IRoleDao.findAddRolesByUserId"))
    })
    UserInfo findUserByIdAndAllRole(String userId);


    @Select("select * from role where id not in (select roleId from users_role where userId=#{userId})")
    List<Role> findOtherRoles(String userId);

    @Insert("insert into users_role values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
