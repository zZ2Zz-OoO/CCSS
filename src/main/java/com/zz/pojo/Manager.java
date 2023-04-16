package com.zz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Manager implements Serializable {
    @TableId(value = "manager_id", type = IdType.ASSIGN_ID)
    private Integer managerId;
    private String managerName;
    private String password;

}
