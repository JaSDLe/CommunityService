package com.jason.news.dao.vo;

import lombok.Data;

import java.util.Date;

@Data
public class News {

    private String newsId;

    private String title;

    private String cover;

    private Integer replyNum;

    private String communityId;

    private Boolean delFlg;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String content;
}