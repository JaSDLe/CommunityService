package com.jason.member.biz.impl;

import com.jason.member.biz.IAccountBiz;
import com.jason.member.dao.vo.Account;
import com.jason.member.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AccountBiz implements IAccountBiz {

    @Autowired
    private IAccountService accountService;

    @Override
    public List<Account> findAll() {
        return accountService.findAll();
    }
}
