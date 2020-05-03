package com.jason.community.service;

import com.jason.community.dao.vo.Community;

import java.util.List;

public interface ICommunityService {

    List<Community> findAll();

    Community findByCommunityId(String communityId);
}
