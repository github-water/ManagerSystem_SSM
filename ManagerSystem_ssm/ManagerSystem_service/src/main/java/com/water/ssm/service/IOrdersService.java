package com.water.ssm.service;

import com.water.ssm.domain.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单操作接口
 */
public interface IOrdersService {

    /**
     * 查询所有订单信息
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    List<Orders> findAll(int page, int size) throws Exception;

    /**
     * 根据id查询订单详情
     * @param id
     * @return
     */
    Orders findById(String id);
}
