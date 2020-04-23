package com.jason.member.api.service;

import com.jason.member.api.dto.AccountDTO;
import com.jason.member.api.dto.LoginDTO;
import com.jason.member.api.dto.RegisterDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "service-member")
public interface IAccountService {

    @RequestMapping(method = RequestMethod.GET, path = "/account/findAll", consumes = "application/json")
    List<AccountDTO> findAll();

    @RequestMapping(method = RequestMethod.POST, path = "/account/login", consumes = "application/json")
    Boolean login(@RequestBody LoginDTO loginDTO);

    @RequestMapping(method = RequestMethod.POST, path = "/account/register", consumes = "application/json")
    Boolean register(@RequestBody RegisterDTO registerDTO);
}
