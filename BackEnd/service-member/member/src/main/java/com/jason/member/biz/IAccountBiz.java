package com.jason.member.biz;

import com.jason.member.api.dto.AccountDTO;
import com.jason.member.api.dto.AccountSimpleDTO;
import com.jason.member.api.dto.LoginDTO;
import com.jason.member.api.dto.RegisterDTO;
import com.jason.member.dao.vo.Account;

import java.util.List;

public interface IAccountBiz {

    List<Account> findAll();

    AccountSimpleDTO login(LoginDTO loginDTO);

    Boolean register(RegisterDTO registerDTO);

    List<AccountSimpleDTO> findAdminListByCommunityId(String communityId);

    Integer findPopulationByCommunityId(String communityId);

    Boolean joinCommunity(String accountId, String communityId);

    Boolean updateAccountBaseInfo(AccountDTO accountDTO);
}
