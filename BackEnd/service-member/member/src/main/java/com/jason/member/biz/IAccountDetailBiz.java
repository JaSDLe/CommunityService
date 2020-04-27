package com.jason.member.biz;

import com.jason.member.api.dto.AccountDetailDTO;

public interface IAccountDetailBiz {

    AccountDetailDTO findAccountDetailByAccountId(String accountId);

    Boolean updateAccountDetailByAccountId(AccountDetailDTO accountDetailDTO);
}
