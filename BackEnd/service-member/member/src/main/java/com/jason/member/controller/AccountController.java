package com.jason.member.controller;

import com.jason.member.api.dto.AccountDTO;
import com.jason.member.biz.IAccountBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
