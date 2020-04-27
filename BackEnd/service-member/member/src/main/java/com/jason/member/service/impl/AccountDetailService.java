package com.jason.member.service.impl;

import com.jason.member.dao.mapper.AccountDetailMapper;
import com.jason.member.dao.vo.AccountDetail;
import com.jason.member.service.IAccountDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class AccountDetailService implements IAccountDetailService {

    @Autowired
    private AccountDetailMapper accountDetailMapper;

    @Override
    public AccountDetail findAccountDetailByAccountId(String accountId) {
        return accountDetailMapper.findAccountDetailByAccountId(accountId);
    }

    @Override
    public Integer updateAccountDetailByAccountId(AccountDetail accountDetail) {
        accountDetail.setUpdateTime(new Date());
        return accountDetailMapper.updateAccountDetailByAccountId(accountDetail);
    }
}
