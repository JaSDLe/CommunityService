package com.jason.member.biz.impl;

import com.jason.member.api.dto.AccountDTO;
import com.jason.member.api.dto.LoginDTO;
import com.jason.member.api.dto.RegisterDTO;
import com.jason.member.biz.IAccountBiz;
import com.jason.member.dao.vo.Account;
import com.jason.member.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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

    @Override
    public Boolean login(LoginDTO loginDTO) {
        return accountService.login(loginDTO);
    }

    @Override
    public Boolean register(RegisterDTO registerDTO) {
        if (accountService.isUsernameOnly(registerDTO.getUsername())) {
            return accountService.createAccount(dTO2VO(registerDTO)) == 1;
        }
        return false;
    }

    private Account dTO2VO(AccountDTO accountDTO) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDTO, account);
        return account;
    }

    private Account dTO2VO(RegisterDTO registerDTO) {
        Account account = new Account();
        BeanUtils.copyProperties(registerDTO, account);
        return account;
    }
}
