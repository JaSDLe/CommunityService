package com.jason.community.controller;

import com.jason.community.api.dto.CommunityDTO;
import com.jason.community.biz.ICommunityBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
