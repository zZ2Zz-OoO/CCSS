package com.zz.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class ServiceType implements Serializable {
   private BigInteger serviceId;
   private String serviceName;
   private String serviceInfo;

}
