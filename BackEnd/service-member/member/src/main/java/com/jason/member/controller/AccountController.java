package com.jason.member.controller;

import com.jason.member.api.dto.AccountDTO;
import com.jason.member.api.dto.AccountSimpleDTO;
import com.jason.member.api.dto.LoginDTO;
import com.jason.member.api.dto.RegisterDTO;
import com.jason.member.biz.IAccountBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountBiz accountBiz;

    @PostMapping("/login")
    public AccountSimpleDTO login(@RequestBody LoginDTO loginDTO) {
        return accountBiz.login(loginDTO);
    }

    @PostMapping("/register")
    public Boolean register(@RequestBody RegisterDTO registerDTO) {
        return accountBiz.register(registerDTO);
    }

    @GetMapping("/findAdminListByCommunityId")
    public List<AccountSimpleDTO> findAdminListByCommunityId(@RequestParam("communityId") String communityId) {
        return accountBiz.findAdminListByCommunityId(communityId);
    }

    @GetMapping("/findPopulationByCommunityId")
    public Integer findPopulationByCommunityId(@RequestParam("communityId") String communityId) {
        return accountBiz.findPopulationByCommunityId(communityId);
    }

    @PutMapping("/joinCommunity")
    public Boolean joinCommunity(@RequestParam("accountId") String accountId, @RequestParam(value = "communityId", required = false) String communityId, @RequestParam("operator") String operator) {
        return accountBiz.joinCommunity(accountId, communityId, operator);
    }

    @PutMapping("/becomeAdmin")
    public Boolean becomeAdmin(@RequestParam("accountId") String accountId) {
        return accountBiz.becomeAdmin(accountId);
    }

    @PutMapping("/updateAccountBaseInfo")
    public Boolean updateAccountBaseInfo(@RequestBody AccountDTO accountDTO) {
        return accountBiz.updateAccountBaseInfo(accountDTO);
    }
}
