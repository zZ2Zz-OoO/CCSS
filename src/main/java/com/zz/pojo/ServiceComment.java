package com.zz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceComment implements Serializable {
    @TableId(value = "comment_id", type = IdType.ASSIGN_ID)
    private Integer commentId;
    private Integer userId;
    private String context;
    private String date;
    private Integer commentLevel;
    private Integer serviceOrderId;
//    private Integer houseKeeperId;
}
