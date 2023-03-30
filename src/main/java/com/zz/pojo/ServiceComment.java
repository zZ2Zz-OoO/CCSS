package com.zz.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class ServiceComment implements Serializable {
    private BigInteger commentId;
    private BigInteger userId;
    private String context;
    private String date;
    private Integer commentLevel;
    private BigInteger serviceOrderId;
}
