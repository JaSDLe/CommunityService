package com.jason.community.dao.mapper;


import com.jason.community.dao.vo.Community;

public interface CommunityMapper {

    int deleteByPrimaryKey(String communityId);

    int insert(Community record);

    int insertSelective(Community record);

    Community selectByPrimaryKey(String communityId);

    int updateByPrimaryKeySelective(Community record);

    int updateByPrimaryKey(Community record);
}