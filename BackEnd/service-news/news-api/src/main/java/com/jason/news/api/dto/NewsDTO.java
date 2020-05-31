package com.jason.news.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class NewsDTO {

    private String newsId;

    private String title;

    private String cover;

    private Integer replyNum;

    private String communityId;

    private Boolean delFlg;

    private String createUser;

    private String author;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String content;
}
