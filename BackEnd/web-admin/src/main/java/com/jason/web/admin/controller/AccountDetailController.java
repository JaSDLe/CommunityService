package com.jason.web.admin.controller;

import com.jason.member.api.dto.AccountDetailDTO;
import com.jason.member.api.service.IAccountDetailService;
import com.jason.web.admin.dto.ItemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/accountDetail")
public class AccountDetailController {

    @Autowired
    private IAccountDetailService accountDetailService;

    @GetMapping("/findAccountDetailByAccountId")
    public ItemResult<AccountDetailDTO> findAccountDetailByAccountId(String accountId) {
        return new ItemResult<>(accountDetailService.findAccountDetailByAccountId(accountId));
    }

    @PostMapping("/updateAccountDetailByAccountId")
    public ItemResult<Boolean> updateAccountDetailByAccountId(@RequestBody AccountDetailDTO accountDetailDTO) {
        return new ItemResult<>(accountDetailService.updateAccountDetailByAccountId(accountDetailDTO));
    }
}
