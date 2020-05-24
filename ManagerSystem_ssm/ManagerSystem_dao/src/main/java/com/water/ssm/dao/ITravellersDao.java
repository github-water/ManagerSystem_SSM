package com.water.ssm.dao;

import com.water.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 游客信息操作dao层
 */
@Repository
public interface ITravellersDao {

    /**
     * 根据
     * @return
     * @throws Exception
     */
    @Select("select * from Traveller where id in (select travellerId from order_traveller where orderId = #{orderId})")
    public List<Traveller> findTravellersById(String orderId) throws Exception;
}
