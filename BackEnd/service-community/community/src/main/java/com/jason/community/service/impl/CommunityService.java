package com.jason.community.service.impl;

import com.jason.community.dao.mapper.CommunityMapper;
import com.jason.community.dao.vo.Community;
import com.jason.community.service.ICommunityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CommunityService implements ICommunityService {

    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public List<Community> findAll() {
        return communityMapper.findAll();
    }

    @Override
    public Community findByCommunityId(String communityId) {
        return communityMapper.findByCommunityId(communityId);
    }

    @Override
    public Integer createCommunity(Community community) {
        community.setCommunityId(UUID.randomUUID().toString().replace("-", ""));
        community.setDelFlg(Boolean.FALSE);
        community.setCreateTime(new Date());
        community.setUpdateTime(new Date());
        return communityMapper.insert(community);
    }

    @Override
    public Integer updateCommunity(Community community) {
        community.setUpdateTime(new Date());
        return communityMapper.updateCommunity(community);
    }

    @Override
    public Integer deleteCommunity(String communityId, String operator) {
        return communityMapper.deleteByPrimaryKey(communityId, operator);
    }
}
