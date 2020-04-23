package com.jason.news.dao.vo;

import lombok.Data;

import java.util.Date;

@Data
public class Notice {

    private String noticeId;

    private String title;

    private Date startTime;

    private Date endTime;

    private String communityId;

    private Boolean delFlg;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String content;
}