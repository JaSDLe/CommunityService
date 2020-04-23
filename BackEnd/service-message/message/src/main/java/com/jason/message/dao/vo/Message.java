package com.jason.message.dao.vo;

import lombok.Data;

import java.util.Date;

@Data
public class Message {

    private String id;

    private String senderId;

    private String receiverId;

    private String parentId;

    private String content;

    private Boolean delFlg;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
}