package com.jason.member.api.service;

import com.jason.member.api.dto.AccountDTO;
import com.jason.member.api.dto.AccountSimpleDTO;
import com.jason.member.api.dto.LoginDTO;
import com.jason.member.api.dto.RegisterDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "service-member")
public interface IAccountService {

    @RequestMapping(method = RequestMethod.POST, path = "/account/login", consumes = "application/json")
    AccountSimpleDTO login(@RequestBody LoginDTO loginDTO);

    @RequestMapping(method = RequestMethod.POST, path = "/account/register", consumes = "application/json")
    Boolean register(@RequestBody RegisterDTO registerDTO);

    @RequestMapping(method = RequestMethod.GET, path = "/account/findAdminListByCommunityId", consumes = "application/json")
    List<AccountSimpleDTO> findAdminListByCommunityId(@RequestParam("communityId") String communityId);

    @RequestMapping(method = RequestMethod.GET, path = "/account/findPopulationByCommunityId", consumes = "application/json")
    Integer findPopulationByCommunityId(@RequestParam("communityId") String communityId);

    @RequestMapping(method = RequestMethod.PUT, path = "/account/joinCommunity", consumes = "application/json")
    Boolean joinCommunity(@RequestParam("accountId") String accountId, @RequestParam(value = "communityId", required = false) String communityId, @RequestParam("operator") String operator);

    @RequestMapping(method = RequestMethod.PUT, path = "/account/becomeAdmin", consumes = "application/json")
    Boolean becomeAdmin(@RequestParam("accountId") String accountId);

    @RequestMapping(method = RequestMethod.PUT, path = "/account/updateAccountBaseInfo", consumes = "application/json")
    Boolean updateAccountBaseInfo(@RequestBody AccountDTO accountDTO);

    @RequestMapping(method = RequestMethod.GET, path = "/account/isUsernameOnly", consumes = "application/json")
    Boolean isUsernameOnly(@RequestParam("username") String username);

    @RequestMapping(method = RequestMethod.GET, path = "/account/findAccountIdByUsername", consumes = "application/json")
    String findAccountIdByUsername(@RequestParam("username") String username);

}
