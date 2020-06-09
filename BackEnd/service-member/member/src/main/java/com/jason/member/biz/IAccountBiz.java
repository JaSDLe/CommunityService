package com.jason.member.biz;

import com.jason.member.api.dto.AccountDTO;
import com.jason.member.api.dto.AccountSimpleDTO;
import com.jason.member.api.dto.LoginDTO;
import com.jason.member.api.dto.RegisterDTO;

import java.util.List;

public interface IAccountBiz {

    AccountSimpleDTO login(LoginDTO loginDTO);

    Boolean register(RegisterDTO registerDTO);

    List<AccountSimpleDTO> findAdminListByCommunityId(String communityId);

    Integer findPopulationByCommunityId(String communityId);

    Boolean joinCommunity(String accountId, String communityId, String operator);

    Boolean becomeAdmin(String accountId);

    Boolean updateAccountBaseInfo(AccountDTO accountDTO);

    Boolean isUsernameOnly(String username);
}
