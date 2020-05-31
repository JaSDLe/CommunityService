package com.jason.member.biz.impl;

import com.jason.member.api.dto.AccountDTO;
import com.jason.member.api.dto.AccountSimpleDTO;
import com.jason.member.api.dto.LoginDTO;
import com.jason.member.api.dto.RegisterDTO;
import com.jason.member.biz.IAccountBiz;
import com.jason.member.dao.vo.Account;
import com.jason.member.service.IAccountDetailService;
import com.jason.member.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AccountBiz implements IAccountBiz {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IAccountDetailService accountDetailService;

    @Override
    public AccountSimpleDTO login(LoginDTO loginDTO) {
        AccountSimpleDTO accountSimpleDTO = vO2DTO(accountService.findAccountByUsername(loginDTO.getUsername()));
        if (accountSimpleDTO != null && StringUtils.isNotBlank(accountSimpleDTO.getAccountId())) {
            loginDTO.setAccountId(accountSimpleDTO.getAccountId());
            if (accountService.login(loginDTO)) {
                return accountSimpleDTO;
            }
        }
        return null;
    }

    @Override
    public Boolean register(RegisterDTO registerDTO) {
        if (accountService.isUsernameOnly(registerDTO.getUsername())) {
            String result = accountService.createAccount(dTO2VO(registerDTO));
            if (result != null) {
                return accountDetailService.createAccountDetail(result) == 1;
            }
        }
        return false;
    }

    @Override
    public List<AccountSimpleDTO> findAdminListByCommunityId(String communityId) {
        return accountService.findAdminListByCommunityId(communityId).stream().map(this::vO2DTO).collect(Collectors.toList());
    }

    @Override
    public Integer findPopulationByCommunityId(String communityId) {
        return accountService.findPopulationByCommunityId(communityId);
    }

    @Override
    public Boolean joinCommunity(String accountId, String communityId, String operator) {
        return accountService.joinCommunity(accountId, communityId, operator) == 1;
    }

    @Override
    public Boolean becomeAdmin(String accountId) {
        return accountService.becomeAdmin(accountId) == 1;
    }

    @Override
    public Boolean updateAccountBaseInfo(AccountDTO accountDTO) {
        return accountService.updateAccountBaseInfo(dTO2VO(accountDTO)) == 1;
    }

    private Account dTO2VO(AccountDTO accountDTO) {
        if (accountDTO == null) {
            return null;
        }
        Account account = new Account();
        BeanUtils.copyProperties(accountDTO, account);
        return account;
    }

    private Account dTO2VO(RegisterDTO registerDTO) {
        if (registerDTO == null) {
            return null;
        }
        Account account = new Account();
        BeanUtils.copyProperties(registerDTO, account);
        return account;
    }

    private AccountSimpleDTO vO2DTO(Account account) {
        if (account == null) {
            return null;
        }
        AccountSimpleDTO accountSimpleDTO = new AccountSimpleDTO();
        BeanUtils.copyProperties(account, accountSimpleDTO);
        return accountSimpleDTO;
    }
}
