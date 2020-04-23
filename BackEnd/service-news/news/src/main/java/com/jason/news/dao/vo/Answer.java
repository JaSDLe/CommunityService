package com.jason.news.dao.vo;

import lombok.Data;

import java.util.Date;

@Data
public class Answer {

    private String answerId;

    private String parentId;

    private String content;

    private Boolean delFlg;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
}