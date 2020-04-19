package com.jason.member.api.service;

import com.jason.member.api.dto.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "service-member")
public interface IAccountService {

    @RequestMapping(method = RequestMethod.GET, path = "/account/findAll", consumes = "application/json")
    List<AccountDTO> findAll();
}
