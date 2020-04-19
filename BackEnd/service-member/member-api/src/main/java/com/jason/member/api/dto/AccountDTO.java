package com.jason.member.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AccountDTO {

    private String accountId;

    private String communityId;

    private String username;

    private String password;

    private Integer type;

    private String nickname;

    private String phone;

    private String email;

    private Boolean delFlg;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
}
