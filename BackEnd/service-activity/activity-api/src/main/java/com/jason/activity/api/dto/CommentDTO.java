package com.jason.activity.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDTO {

    private String commentId;

    private String content;

    private String parentId;

    private Boolean delFlg;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
}