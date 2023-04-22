package com.zz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
     @TableId(value = "user_id", type = IdType.ASSIGN_ID)
     private Integer userId;
     private String userName;
     private String password;
     private String phone;
     private String realName;
    private String sex;
    private String cardId;
     private String address;
     private Integer communityId;

}
