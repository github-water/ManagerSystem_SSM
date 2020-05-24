package com.water.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.water.ssm.dao.IOrdersDao;
import com.water.ssm.domain.Orders;
import com.water.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    /**
     * 根据当前页和记录数查询订单
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        //设置分页属性
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    /**
     * 根据订单唯一id查询订单详情
     * @param id
     * @return
     */
    @Override
    public Orders findById(String id) {
        return ordersDao.findById(id);
    }
}
