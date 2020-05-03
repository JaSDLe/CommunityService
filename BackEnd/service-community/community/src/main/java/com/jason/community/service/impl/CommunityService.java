package com.jason.community.service.impl;

import com.jason.community.dao.mapper.CommunityMapper;
import com.jason.community.dao.vo.Community;
import com.jason.community.service.ICommunityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
