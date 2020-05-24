package com.water.ssm.service.impl;

import com.water.ssm.dao.IProductDao;
import com.water.ssm.domain.Product;
import com.water.ssm.service.IProductSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * 商品业务层实现类
 */

@Service()
@Transactional
public class ProductServiceImpl implements IProductSevice {

    @Autowired
    private IProductDao productDao;

    /**
     * 查询所有商品信息
     * @return
     * @throws Exception
     */
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    /**
     * 添加新增商品信息
     * @throws Exception
     */
    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
