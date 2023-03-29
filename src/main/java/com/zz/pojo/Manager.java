package com.zz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class Manager implements Serializable {
    @TableId(value = "manager_id", type = IdType.ASSIGN_ID)
    private BigInteger managerId;
    private String ManagerName;
    private String password;

}
