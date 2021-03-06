package com.jason.member.controller;

import com.jason.member.api.dto.AccountDetailDTO;
import com.jason.member.api.dto.AccountSimpleDTO;
import com.jason.member.biz.IAccountDetailBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/accountDetail")
public class AccountDetailController {

    @Autowired
    private IAccountDetailBiz accountDetailBiz;

    @GetMapping("/findAccountDetailByAccountId")
    public AccountDetailDTO findAccountDetailByAccountId(@RequestParam("accountId") String accountId) {
        return accountDetailBiz.findAccountDetailByAccountId(accountId);
    }

    @GetMapping("/findSimpleAccountByAccountId")
    public AccountSimpleDTO findSimpleAccountByAccountId(@RequestParam("accountId") String accountId) {
        return accountDetailBiz.findSimpleAccountByAccountId(accountId);
    }

    @PutMapping("/updateAccountDetailByAccountId")
    public Boolean updateAccountDetailByAccountId(@RequestBody AccountDetailDTO accountDetailDTO) {
        return accountDetailBiz.updateAccountDetailByAccountId(accountDetailDTO);
    }
}
