package com.jason.community.dao.vo;

import lombok.Data;

import java.util.Date;

@Data
public class Community {

    private String communityId;

    private String communityName;

    private String communityInfo;

    private String index;

    private Boolean delFlg;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
}