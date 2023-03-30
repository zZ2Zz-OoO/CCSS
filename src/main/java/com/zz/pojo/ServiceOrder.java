package com.zz.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Data
public class ServiceOrder implements Serializable {
    private BigInteger serviceOrderId;
    private BigInteger userId;
    private BigInteger typeId;
    private String address;
    private BigInteger communityId;
    private Date postDate;
    private Date getDate;
    private String phone;
    private Integer isFinished;
    private BigInteger houseKeeperId;

}
