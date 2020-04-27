package com.jason.member.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AccountDetailDTO {

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