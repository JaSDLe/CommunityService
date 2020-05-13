package com.jason.news.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AnswerDTO {

    private String answerId;

    private String parentId;

    private String content;

    private Boolean delFlg;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
}
