package com.jason.member.service.impl;

import com.jason.member.api.dto.LoginDTO;
import com.jason.member.api.enums.AccountTypeEnum;
import com.jason.member.dao.mapper.AccountMapper;
import com.jason.member.dao.vo.Account;
import com.jason.member.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Boolean login(LoginDTO loginDTO) {
        return accountMapper.login(loginDTO.getUsername(), this.addSalt(loginDTO.getPassword(), loginDTO.getAccountId()));
    }

    @Override
    public Boolean isUsernameOnly(String username) {
        return accountMapper.isUsernameOnly(username);
    }

    @Override
    public String createAccount(Account account) {
        account.setAccountId(UUID.randomUUID().toString().replace("-", ""));
        account.setPassword(this.addSalt(account.getPassword(), account.getAccountId()));
        account.setType(AccountTypeEnum.RESIDENT.getKey());
        account.setDelFlg(Boolean.FALSE);
        account.setCreateUser("system");
        account.setCreateTime(new Date());
        account.setUpdateUser("system");
        account.setUpdateTime(new Date());
        log.info("=====> createAccount : {}", account);
        if (accountMapper.insertSelective(account) == 1) {
            return account.getAccountId();
        } else {
            return null;
        }
    }

    @Override
    public Account findAccountByUsername(String username) {
        return accountMapper.findAccountByUsername(username);
    }

    @Override
    public Account findAccountByAccountId(String accountId) {
        return accountMapper.findAccountByAccountId(accountId);
    }

    @Override
    public List<Account> findAdminListByCommunityId(String communityId) {
        return accountMapper.findAdminListByCommunityId(communityId, AccountTypeEnum.ADMINISTRATOR.getKey());
    }

    @Override
    public Integer findPopulationByCommunityId(String communityId) {
        return accountMapper.findPopulationByCommunityId(communityId, AccountTypeEnum.RESIDENT.getKey());
    }

    @Override
    public Integer joinCommunity(String accountId, String communityId, String operator) {
        return accountMapper.joinCommunity(accountId, communityId, AccountTypeEnum.RESIDENT.getKey(), operator);
    }

    @Override
    public Integer becomeAdmin(String accountId) {
        return accountMapper.becomeAdmin(accountId, AccountTypeEnum.ADMINISTRATOR.getKey());
    }

    @Override
    public Integer updateAccountBaseInfo(Account account) {
        if (StringUtils.isEmpty(account.getUpdateUser())) {
            account.setUpdateUser(account.getAccountId());
        }
        account.setUpdateTime(new Date());
        return accountMapper.updateAccountBaseInfo(account);
    }

    @Override
    public String findAccountIdByUsername(String username) {
        return accountMapper.findAccountIdByUsername(username);
    }

    private String addSalt(String password, String salt) {
        return DigestUtils.md5DigestAsHex((password + salt).getBytes());
    }
}
