package com.zz.pojo;

import lombok.Data;

import java.math.BigInteger;
@Data
public class User {
     private BigInteger userId;
     private String userName ;
     private String password;
     private String phone;
     private String realName;
     private Sex sex;
     private String cardId;
     private String address;
     private BigInteger addId;

}
