package com.zz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceOrder implements Serializable {
    @TableId(value = "service_order_id", type = IdType.ASSIGN_ID)
    private Integer serviceOrderId;
    private Integer userId;
    private Integer typeId;
    private String address;
    private Integer communityId;
    private String postDate;
    private String getDate;
    private String phone;
    private Integer isFinished;
    private Integer houseKeeperId;
    private String info;

}
