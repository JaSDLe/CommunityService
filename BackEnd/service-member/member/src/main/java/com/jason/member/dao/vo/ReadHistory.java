package com.jason.member.dao.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ReadHistory {

    private String id;

    private Integer type;

    private String accountId;

    private String contentId;

    private Boolean delFlg;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
}