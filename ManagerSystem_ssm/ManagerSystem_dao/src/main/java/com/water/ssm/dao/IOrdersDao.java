package com.water.ssm.dao;

import com.water.ssm.domain.Member;
import com.water.ssm.domain.Orders;
import com.water.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单操作持久层
 */
@Repository
public interface IOrdersDao {

    /**
     * 查询所有订单
     * @return
     * @throws Exception
     */
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId", property = "product", javaType = Product.class,one = @One(select = "com.water.ssm.dao.IProductDao.findProductById"))
    })
    List<Orders> findAll() throws Exception;


    /**
     * 根据id查询Orders详情
     * @param id
     * @return
     */
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId", property = "product", javaType = Product.class,one = @One(select = "com.water.ssm.dao.IProductDao.findProductById")),
            @Result(column = "memberId", property = "member", javaType = Member.class,one = @One(select = "com.water.ssm.dao.IMemberDao.findMemberById")),
            @Result(column = "id", property = "travellers", javaType = java.util.List.class, many = @Many(select = "com.water.ssm.dao.ITravellersDao.findTravellersById"))
    })
    Orders findById(String id);
}
