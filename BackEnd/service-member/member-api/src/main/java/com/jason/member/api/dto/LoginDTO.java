package com.jason.member.api.dto;

import lombok.Data;

@Data
public class LoginDTO {

    private String accountId;

    private String username;

    private String password;
}
