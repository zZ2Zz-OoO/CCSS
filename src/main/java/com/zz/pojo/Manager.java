package com.zz.pojo;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Manager {
    private BigInteger managerId;
    private String ManagerName;
    private String password;

}
