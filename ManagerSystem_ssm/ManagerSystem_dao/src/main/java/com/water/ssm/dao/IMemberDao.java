package com.water.ssm.dao;

import com.water.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 会员信息Dao层接口
 */
@Repository
public interface IMemberDao {

    /**
     * 根据memberid查询会员信息
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from member where id=#{id}")
    Member findMemberById(String id) throws Exception;
}
