package com.jason.message.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MessageDTO {

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

    private String receiver;

    private String headPic;

    private String lastContent;

    private Integer unreadCount;
}
