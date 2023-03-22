package com.zz.pojo;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;


@Data
public class Housekeeper {
    private BigInteger houseKeepingId;
    private String name;
    private String password;
    private String companyName;
    private String address;
    private String info;
    private String phone;
    private Date date;

}
