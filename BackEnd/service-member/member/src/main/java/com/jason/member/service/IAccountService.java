package com.jason.member.service;

import com.jason.member.dao.vo.Account;

import java.util.List;

public interface IAccountService {

    List<Account> findAll();
}
