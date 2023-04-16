package com.zz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class HouseKeeper implements Serializable {
    @TableId(value = "house_keeper_id", type = IdType.ASSIGN_ID)
    private Integer houseKeepingId;
    private String houseKeeperName;
    private String password;
    private String companyName;
    private String address;
    private Integer isCheck;
    private String info;
    private String phone;
    private Date date;

}
