package com.jason.member.biz;

import com.jason.member.api.dto.LoginDTO;
import com.jason.member.api.dto.RegisterDTO;
import com.jason.member.dao.vo.Account;

import java.util.List;

public interface IAccountBiz {

    List<Account> findAll();

    Boolean login(LoginDTO loginDTO);

    Boolean register(RegisterDTO registerDTO);
}
