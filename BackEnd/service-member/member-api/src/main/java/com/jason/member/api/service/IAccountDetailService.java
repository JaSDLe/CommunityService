package com.jason.member.api.service;

import com.jason.member.api.dto.AccountDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "service-member")
public interface IAccountDetailService {

    @RequestMapping(method = RequestMethod.GET, path = "/accountDetail/findAccountDetailByAccountId", consumes = "application/json")
    AccountDetailDTO findAccountDetailByAccountId(String accountId);

    @RequestMapping(method = RequestMethod.PUT, path = "/accountDetail/updateAccountDetailByAccountId", consumes = "application/json")
    Boolean updateAccountDetailByAccountId(@RequestBody AccountDetailDTO accountDetailDTO);
}
