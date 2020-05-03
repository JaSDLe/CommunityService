package com.jason.member.api.dto;

import lombok.Data;

@Data
public class AccountSimpleDTO {

    private String accountId;

    private String communityId;

    private String username;

    private Integer type;

    private String nickname;

    private String phone;

    private String email;
}
