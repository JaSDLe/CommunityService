package com.jason.community.service;

import com.jason.community.dao.vo.Community;

import java.util.List;

public interface ICommunityService {

    List<Community> findAll();

    Community findByCommunityId(String communityId);

    Integer createCommunity(Community community);

    Integer updateCommunity(Community community);

    Integer deleteCommunity(String communityId, String operator);
}
