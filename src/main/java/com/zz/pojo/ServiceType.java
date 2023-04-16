package com.zz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceType implements Serializable {
   @TableId(value = "service_id", type = IdType.ASSIGN_ID)
   private Integer serviceId;
   private String serviceName;
   private String serviceInfo;

}
