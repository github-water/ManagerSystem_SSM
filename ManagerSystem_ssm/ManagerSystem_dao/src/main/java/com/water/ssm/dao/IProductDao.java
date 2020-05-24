package com.water.ssm.dao;


import com.water.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品持久层接口
 */
@Repository
public interface IProductDao {

    /**
     * 查询所有的商品信息
     * @return
     * @throws Exception
     */
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    /**
     * 插入新增商品数据
     * @throws Exception
     */
    @Insert("insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(uuid(),#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void save(Product product) throws Exception;

    /**
     * 根据id查询商品信息
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from product where id=#{id}")
    Product findProductById(String id) throws Exception;
}
