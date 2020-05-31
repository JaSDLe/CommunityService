package com.jason.member.service;

import com.jason.member.api.dto.LoginDTO;
import com.jason.member.dao.vo.Account;

import java.util.List;

public interface IAccountService {

    Boolean login(LoginDTO loginDTO);

    Boolean isUsernameOnly(String username);

    String createAccount(Account account);

    Account findAccountByUsername(String username);

    Account findAccountByAccountId(String accountId);

    List<Account> findAdminListByCommunityId(String communityId);

    Integer findPopulationByCommunityId(String communityId);

    Integer joinCommunity(String accountId, String communityId, String operator);

    Integer becomeAdmin(String accountId);

    Integer updateAccountBaseInfo(Account account);
}
