package com.jason.member.service;

import com.jason.member.api.dto.LoginDTO;
import com.jason.member.dao.vo.Account;

import java.util.List;

public interface IAccountService {

    List<Account> findAll();

    Boolean login(LoginDTO loginDTO);

    Boolean isUsernameOnly(String username);

    Integer createAccount(Account account);
}
