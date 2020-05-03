package com.jason.member.biz;

import com.jason.member.api.dto.AccountDetailDTO;
import com.jason.member.api.dto.AccountSimpleDTO;

public interface IAccountDetailBiz {

    AccountDetailDTO findAccountDetailByAccountId(String accountId);

    Boolean updateAccountDetailByAccountId(AccountDetailDTO accountDetailDTO);

    AccountSimpleDTO findSimpleAccountByAccountId(String accountId);
}
