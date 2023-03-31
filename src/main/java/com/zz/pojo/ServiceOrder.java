package com.zz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class ServiceOrder implements Serializable {
    @TableId(value = "service_order_id", type = IdType.ASSIGN_ID)
    private BigInteger serviceOrderId;
    private BigInteger userId;
    private BigInteger typeId;
    private String address;
    private BigInteger communityId;
    private String postDate;
    private String getDate;
    private String phone;
    private Integer isFinished;
    private BigInteger houseKeeperId;

}
