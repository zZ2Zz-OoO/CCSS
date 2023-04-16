package com.zz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Community implements Serializable {
    @TableId(value = "community_id", type = IdType.ASSIGN_ID)
    private Integer communityId;
    private String communityName;
    private String communityInfo;
}
