package com.jason.member.biz.impl;

import com.jason.member.api.dto.AccountDetailDTO;
import com.jason.member.api.dto.AccountSimpleDTO;
import com.jason.member.biz.IAccountDetailBiz;
import com.jason.member.dao.vo.Account;
import com.jason.member.dao.vo.AccountDetail;
import com.jason.member.service.IAccountDetailService;
import com.jason.member.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountDetailBiz implements IAccountDetailBiz {

    @Autowired
    private IAccountDetailService accountDetailService;

    @Autowired
    private IAccountService accountService;

    @Override
    public AccountDetailDTO findAccountDetailByAccountId(String accountId) {
        return vO2DTO(accountDetailService.findAccountDetailByAccountId(accountId));
    }

    @Override
    public Boolean updateAccountDetailByAccountId(AccountDetailDTO accountDetailDTO) {
        return accountDetailService.updateAccountDetailByAccountId(dTO2VO(accountDetailDTO)) == 1;
    }

    @Override
    public AccountSimpleDTO findSimpleAccountByAccountId(String accountId) {
        return vO2DTO(accountService.findAccountByAccountId(accountId));
    }

    private AccountDetailDTO vO2DTO(AccountDetail accountDetail) {
        if (accountDetail == null) {
            return null;
        }
        AccountDetailDTO accountDetailDTO = new AccountDetailDTO();
        BeanUtils.copyProperties(accountDetail, accountDetailDTO);
        return accountDetailDTO;
    }

    private AccountSimpleDTO vO2DTO(Account account) {
        if (account == null) {
            return null;
        }
        AccountSimpleDTO accountSimpleDTO = new AccountSimpleDTO();
        BeanUtils.copyProperties(account, accountSimpleDTO);
        return accountSimpleDTO;
    }

    private AccountDetail dTO2VO(AccountDetailDTO accountDetailDTO) {
        if (accountDetailDTO == null) {
            return null;
        }
        AccountDetail accountDetail = new AccountDetail();
        BeanUtils.copyProperties(accountDetailDTO, accountDetail);
        return accountDetail;
    }
}
