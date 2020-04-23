package com.jason.web.user.controller;

import com.jason.member.api.dto.AccountDTO;
import com.jason.member.api.dto.LoginDTO;
import com.jason.member.api.dto.RegisterDTO;
import com.jason.member.api.service.IAccountService;
import com.jason.web.user.dto.ItemResult;
import lombok.extern.slf4j.Slf4j;
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
    public ItemResult<Boolean> login(@RequestBody LoginDTO loginDTO) {
        return new ItemResult<>(accountService.login(loginDTO));
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
}
