package com.jason.member.service.impl;

import com.jason.member.api.dto.LoginDTO;
import com.jason.member.api.enums.AccountTypeEnum;
import com.jason.member.dao.mapper.AccountMapper;
import com.jason.member.dao.vo.Account;
import com.jason.member.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> findAll() {
        return accountMapper.findAll();
    }

    @Override
    public Boolean login(LoginDTO loginDTO) {
        return accountMapper.login(loginDTO.getUsername(), loginDTO.getPassword());
    }

    @Override
    public Boolean isUsernameOnly(String username) {
        return accountMapper.isUsernameOnly(username);
    }

    @Override
    public Integer createAccount(Account account) {
        account.setAccountId(UUID.randomUUID().toString().replace("-", ""));
        account.setType(AccountTypeEnum.RESIDENT.getKey());
        account.setDelFlg(Boolean.FALSE);
        account.setCreateUser("system");
        account.setCreateTime(new Date());
        account.setUpdateUser("system");
        account.setUpdateTime(new Date());
        log.info("=====> createAccount : {}", account);
        return accountMapper.insertSelective(account);
    }
}
