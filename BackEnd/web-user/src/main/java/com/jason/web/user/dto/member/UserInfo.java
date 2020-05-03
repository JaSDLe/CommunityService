package com.jason.web.user.dto.member;

import com.jason.member.api.dto.AccountDetailDTO;
import com.jason.member.api.dto.AccountSimpleDTO;
import lombok.Data;

@Data
public class UserInfo {

    private AccountSimpleDTO accountSimpleDTO;

    private AccountDetailDTO accountDetailDTO;
}
