package com.zz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class ServiceComment implements Serializable {
    @TableId(value = "comment_id", type = IdType.ASSIGN_ID)
    private BigInteger commentId;
    private BigInteger userId;
    private String context;
    private String date;
    private Integer commentLevel;
    private BigInteger serviceOrderId;
    private BigInteger houseKeeperId;
}
