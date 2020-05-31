package com.jason.web.admin.controller;

import com.jason.member.api.service.IAccountService;
import com.jason.web.admin.dto.ItemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @PutMapping("/setAdmin")
    public ItemResult<Boolean> setAdmin(@RequestParam("accountId") String accountId, @RequestParam("communityId") String communityId, @RequestParam("operator") String operator) {
        if (accountService.joinCommunity(accountId, communityId, operator) && accountService.becomeAdmin(accountId)) {
            return new ItemResult<>(true, "更新成功");
        } else {
            return new ItemResult<>(false, "更新失败");
        }
    }

    @PutMapping("/unsetAdmin")
    public ItemResult<Boolean> unsetAdmin(@RequestParam("accountId") String accountId, @RequestParam("operator") String operator) {
        if (accountService.joinCommunity(accountId, null, operator)) {
            return new ItemResult<>(true, "更新成功");
        } else {
            return new ItemResult<>(false, "更新失败");
        }
    }
}
