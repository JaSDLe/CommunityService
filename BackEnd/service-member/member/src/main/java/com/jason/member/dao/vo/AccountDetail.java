package com.jason.member.dao.vo;

import lombok.Data;

import java.util.Date;

@Data
public class AccountDetail {

    private String id;

    private String accountId;

    private Boolean sex;

    private Date birthday;

    private Integer constellation;

    private String address;

    private Boolean delFlg;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
}