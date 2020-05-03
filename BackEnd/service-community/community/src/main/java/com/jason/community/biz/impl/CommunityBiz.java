package com.jason.community.biz.impl;

import com.jason.community.api.dto.CommunityDTO;
import com.jason.community.biz.ICommunityBiz;
import com.jason.community.dao.vo.Community;
import com.jason.community.service.ICommunityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CommunityBiz implements ICommunityBiz {

    @Autowired
    private ICommunityService communityService;

    @Override
    public List<CommunityDTO> findAll() {
        return communityService.findAll().stream().map(this::vO2DTO).collect(Collectors.toList());
    }

    @Override
    public CommunityDTO findByCommunityId(String communityId) {
        return vO2DTO(communityService.findByCommunityId(communityId));
    }

    private CommunityDTO vO2DTO(Community community) {
        if (community == null) {
            return null;
        }
        CommunityDTO communityDTO = new CommunityDTO();
        BeanUtils.copyProperties(community, communityDTO);
        return communityDTO;
    }
}
