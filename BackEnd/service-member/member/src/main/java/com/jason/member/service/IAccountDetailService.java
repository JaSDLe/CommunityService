package com.jason.member.service;

import com.jason.member.dao.vo.AccountDetail;

public interface IAccountDetailService {

    AccountDetail findAccountDetailByAccountId(String accountId);

    Integer updateAccountDetailByAccountId(AccountDetail accountDetail);

    Integer createAccountDetail(String accountId);
}
