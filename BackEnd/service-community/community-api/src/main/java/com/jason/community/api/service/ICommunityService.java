package com.jason.community.api.service;

import com.jason.community.api.dto.CommunityDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(method = RequestMethod.POST, path = "/community/createCommunity", consumes = "application/json")
    Boolean createCommunity(@RequestBody CommunityDTO communityDTO);

    @RequestMapping(method = RequestMethod.PUT, path = "/community/updateCommunity", consumes = "application/json")
    Boolean updateCommunity(@RequestBody CommunityDTO communityDTO);

    @RequestMapping(method = RequestMethod.DELETE, path = "/community/deleteCommunity", consumes = "application/json")
    Boolean deleteCommunity(@RequestParam("communityId") String communityId, @RequestParam("operator") String operator);
}
