package com.water.ssm.service;

import com.water.ssm.domain.Product;

import java.util.List;

/**
 * 商品业务层接口
 */
public interface IProductSevice {

    /**
     * 查询所有商品信息
     * @return
     * @throws Exception
     */
    public List<Product> findAll() throws Exception;

    /**
     * 新增商品信息
     * @throws Exception
     */
    public void save(Product product) throws Exception;
}
