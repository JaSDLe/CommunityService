package com.jason.community.controller;

import com.jason.community.api.dto.CommunityDTO;
import com.jason.community.biz.ICommunityBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private ICommunityBiz communityBiz;

    @GetMapping("/findAll")
    public List<CommunityDTO> findAll() {
        return communityBiz.findAll();
    }

    @GetMapping("/findByCommunityId")
    public CommunityDTO findByCommunityId(@RequestParam("communityId") String communityId) {
        return communityBiz.findByCommunityId(communityId);
    }

    @PostMapping("/createCommunity")
    Boolean createCommunity(@RequestBody CommunityDTO communityDTO) {
        return communityBiz.createCommunity(communityDTO);
    }

    @PutMapping("/updateCommunity")
    Boolean updateCommunity(@RequestBody CommunityDTO communityDTO) {
        return communityBiz.updateCommunity(communityDTO);
    }

    @DeleteMapping("/deleteCommunity")
    Boolean deleteCommunity(@RequestParam("communityId") String communityId, @RequestParam("operator") String operator) {
        return communityBiz.deleteCommunity(communityId, operator);
    }
}
