package com.water.ssm.controller;

import com.water.ssm.domain.Product;
import com.water.ssm.service.IProductSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * Product的控制器
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductSevice productService;

    /**
     * 查询所有商品信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    /*@RolesAllowed("ADMIN")*/
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll();
        mv.addObject("productList",productList);
        mv.setViewName("product-list1");
        return mv;
    }

    /**
     * 新增商品信息，并重新查询
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll.do";
    }
}
