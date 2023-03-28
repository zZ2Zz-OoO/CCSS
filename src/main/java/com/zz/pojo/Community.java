package com.zz.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class Community implements Serializable {
    private BigInteger communityId;
    private String communityName;
    private String communityInfo;
}
