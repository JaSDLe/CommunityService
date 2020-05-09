package com.jason.web.user.controller;

import com.jason.member.api.dto.AccountDetailDTO;
import com.jason.member.api.service.IAccountDetailService;
import com.jason.web.user.dto.ItemResult;
import com.jason.web.user.dto.member.UserInfo;
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

    @GetMapping("/getUserInfoByAccountId")
    public ItemResult<UserInfo> getUserInfoByAccountId(@RequestParam("accountId") String accountId) {
        log.info(accountId);
        UserInfo userInfo = new UserInfo();
        userInfo.setAccountSimpleDTO(accountDetailService.findSimpleAccountByAccountId(accountId));
        userInfo.setAccountDetailDTO(accountDetailService.findAccountDetailByAccountId(accountId));
        return new ItemResult<>(userInfo);
    }

    @PutMapping("/updateAccountDetail")
    public ItemResult<Boolean> updateAccountDetail(@RequestBody AccountDetailDTO accountDetailDTO) {
        if (accountDetailService.updateAccountDetailByAccountId(accountDetailDTO)) {
            return new ItemResult<>(true, "更新成功");
        } else {
            return new ItemResult<>(false, "更新失败");
        }
    }
}
