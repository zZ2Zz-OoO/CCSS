package com.zz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.pojo.ServiceOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ServiceOrderServiceMapper extends BaseMapper<ServiceOrder> {

    @Select("select * from service_order where user_id=#{userId} and is_finished='1';")
    ServiceOrder getByUserId(Integer userId);
}
