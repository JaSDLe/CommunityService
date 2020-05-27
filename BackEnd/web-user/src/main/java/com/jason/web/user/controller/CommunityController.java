package com.jason.web.user.controller;

import com.jason.community.api.dto.CommunityDTO;
import com.jason.community.api.service.ICommunityService;
import com.jason.member.api.dto.ReadHistoryDTO;
import com.jason.member.api.enums.ReadHistoryTypeEnum;
import com.jason.member.api.service.IAccountService;
import com.jason.member.api.service.IReadHistoryService;
import com.jason.web.user.dto.ItemResult;
import com.jason.web.user.dto.community.CommunityDetailDTO;
import com.jason.web.user.dto.community.CommunityIndexDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private ICommunityService communityService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IReadHistoryService readHistoryService;

    @GetMapping("/findAll")
    public ItemResult<List<CommunityIndexDTO>> findAll() {
        List<CommunityIndexDTO> result = new ArrayList<>();
        communityService.findAll()
                .stream()
                .collect(Collectors.groupingBy(CommunityDTO::getIndex))
                .values()
                .forEach(item -> result.add(new CommunityIndexDTO(item)));
        return new ItemResult<>(result);
    }

    @GetMapping("/findDetailByCommunityId")
    public ItemResult<CommunityDetailDTO> findDetailByCommunityId(@RequestParam("communityId") String communityId, @RequestParam("operator") String operator) {
        log.info(communityId);
        CommunityDetailDTO result = new CommunityDetailDTO();
        CommunityDTO communityDTO = communityService.findByCommunityId(communityId);
        if (communityDTO != null) {
            BeanUtils.copyProperties(communityDTO, result);
            result.setAdminList(accountService.findAdminListByCommunityId(communityId));
            result.setPopulation(accountService.findPopulationByCommunityId(communityId));
            readHistoryService.add(new ReadHistoryDTO(ReadHistoryTypeEnum.COMMUNITY.getKey(), operator, communityId));
            return new ItemResult<>(result);
        } else {
            return new ItemResult<>("400", "没有找到该社区");
        }
    }
}
