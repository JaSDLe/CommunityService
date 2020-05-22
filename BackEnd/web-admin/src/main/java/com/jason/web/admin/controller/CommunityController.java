package com.jason.web.admin.controller;

import com.jason.community.api.dto.CommunityDTO;
import com.jason.community.api.service.ICommunityService;
import com.jason.web.admin.dto.ItemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private ICommunityService communityService;

    @PostMapping("/createCommunity")
    public ItemResult<Boolean> createCommunity(@RequestBody CommunityDTO communityDTO) {
        if (communityService.createCommunity(communityDTO)) {
            return new ItemResult<>(true, "创建成功");
        } else {
            return new ItemResult<>(false, "创建失败");
        }
    }

    @PutMapping("/updateCommunity")
    public ItemResult<Boolean> updateCommunity(@RequestBody CommunityDTO communityDTO) {
        if (communityService.updateCommunity(communityDTO)) {
            return new ItemResult<>(true, "更新成功");
        } else {
            return new ItemResult<>(false, "更新失败");
        }
    }

    @DeleteMapping("/deleteCommunity")
    public ItemResult<Boolean> deleteCommunity(@RequestParam("communityId") String communityId, @RequestParam("operator") String operator) {
        if (communityService.deleteCommunity(communityId, operator)) {
            return new ItemResult<>(true, "删除成功");
        } else {
            return new ItemResult<>(false, "删除失败");
        }
    }
}
