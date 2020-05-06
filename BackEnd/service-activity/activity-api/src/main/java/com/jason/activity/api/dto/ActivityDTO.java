package com.jason.activity.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ActivityDTO {

    private String activityId;

    private String content;

    private Integer replyNum;

    private String communityId;

    private Boolean delFlg;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
}
