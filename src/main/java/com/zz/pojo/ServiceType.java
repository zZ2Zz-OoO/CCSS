package com.zz.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class ServiceType implements Serializable {
   private BigInteger service_id;
   private String service_name;
   private String service_info;

}
