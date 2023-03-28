package com.zz.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Data
public class ServiceOrder implements Serializable {
    private BigInteger service_order_id;
    private BigInteger user_id;
    private BigInteger type_id;
    private String address;
    private BigInteger community_id;
    private Date post_date;
    private Date get_date;
    private String phone;
    private Integer is_finished;
    private BigInteger house_keeper_id;

}
