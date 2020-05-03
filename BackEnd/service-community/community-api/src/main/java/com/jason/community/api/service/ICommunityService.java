package com.jason.community.api.service;

import com.jason.community.api.dto.CommunityDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "service-community")
public interface ICommunityService {

    @RequestMapping(method = RequestMethod.GET, path = "/community/findAll", consumes = "application/json")
    List<CommunityDTO> findAll();

    @RequestMapping(method = RequestMethod.GET, path = "/community/findByCommunityId", consumes = "application/json")
    CommunityDTO findByCommunityId(@RequestParam("communityId") String communityId);
}
