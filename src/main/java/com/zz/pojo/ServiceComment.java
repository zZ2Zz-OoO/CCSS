package com.zz.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class ServiceComment implements Serializable {
    private BigInteger comment_id;
    private BigInteger user_id;
    private String context;
    private String date;
    private Integer comment_level;
    private BigInteger service_order_id;
}
