package com.jason.member.biz;

import com.jason.member.dao.vo.Account;

import java.util.List;

public interface IAccountBiz {

    List<Account> findAll();
}
