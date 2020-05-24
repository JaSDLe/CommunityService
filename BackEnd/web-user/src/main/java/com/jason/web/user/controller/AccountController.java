package com.jason.web.user.controller;

import com.jason.member.api.dto.AccountDTO;
import com.jason.member.api.dto.AccountSimpleDTO;
import com.jason.member.api.dto.LoginDTO;
import com.jason.member.api.dto.RegisterDTO;
import com.jason.member.api.service.IAccountService;
import com.jason.web.user.dto.ItemResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping("/findAll")
    public ItemResult<List<AccountDTO>> findAll() {
        return new ItemResult<>(accountService.findAll());
    }

    @PostMapping("/login")
    public ItemResult<AccountSimpleDTO> login(@RequestBody LoginDTO loginDTO) {
        if (loginDTO == null || StringUtils.isBlank(loginDTO.getUsername()) || StringUtils.isBlank(loginDTO.getPassword())) {
            return new ItemResult<>("400", "用户名或密码不能为空");
        }
        AccountSimpleDTO accountSimpleDTO = accountService.login(loginDTO);
        if (accountSimpleDTO != null && accountSimpleDTO.getAccountId() != null) {
            return new ItemResult<>(accountSimpleDTO, "登录成功");
        } else {
            return new ItemResult<>("400", "用户名或密码错误");
        }
    }

    @PostMapping("/register")
    public ItemResult<Boolean> register(@RequestBody RegisterDTO registerDTO) {
        if (!Pattern.matches("^[0-9a-zA-Z]+$", registerDTO.getUsername())) {
            return new ItemResult<>("400", "用户名不符合规范");
        }
        if (!Pattern.matches("^[0-9a-zA-Z~!@#$%^&*()_+-=]{6,20}$", registerDTO.getPassword())) {
            return new ItemResult<>("400", "密码不符合规范");
        }
        if (accountService.register(registerDTO)) {
            return new ItemResult<>(true, "注册成功");
        } else {
            return new ItemResult<>(false, "该用户名已被注册，请更换");
        }
    }

    @PutMapping("/joinCommunity")
    public ItemResult<Boolean> joinCommunity(@RequestParam("accountId") String accountId, @RequestParam("communityId") String communityId) {
        if (accountService.joinCommunity(accountId, communityId)) {
            return new ItemResult<>(true, "加入成功");
        } else {
            return new ItemResult<>(false, "加入失败");
        }
    }

    @PutMapping("/updateAccountBaseInfo")
    public ItemResult<Boolean> updateAccountBaseInfo(@RequestBody AccountDTO accountDTO) {
        if (accountService.updateAccountBaseInfo(accountDTO)) {
            return new ItemResult<>(true, "更新成功");
        } else {
            return new ItemResult<>(false, "更新失败");
        }
    }
}
