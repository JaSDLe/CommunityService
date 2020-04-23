package com.jason.member.controller;

import com.jason.member.api.dto.AccountDTO;
import com.jason.member.api.dto.LoginDTO;
import com.jason.member.api.dto.RegisterDTO;
import com.jason.member.biz.IAccountBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountBiz accountBiz;

    @GetMapping("/findAll")
    public List<AccountDTO> findAll() {
        List<AccountDTO> result = new ArrayList<>();
        accountBiz.findAll().forEach(item -> {
            AccountDTO accountDTO = new AccountDTO();
            BeanUtils.copyProperties(item, accountDTO);
            result.add(accountDTO);
        });
        return result;
    }

    @PostMapping("/login")
    public Boolean login(@RequestBody LoginDTO loginDTO) {
        return accountBiz.login(loginDTO);
    }

    @PostMapping("/register")
    public Boolean register(@RequestBody RegisterDTO registerDTO) {
        return accountBiz.register(registerDTO);
    }
}
