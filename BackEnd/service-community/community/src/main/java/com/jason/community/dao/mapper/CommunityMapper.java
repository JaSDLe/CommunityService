package com.jason.community.dao.mapper;


import com.jason.community.dao.vo.Community;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommunityMapper {

    Integer deleteByPrimaryKey(@Param("communityId") String communityId, @Param("operator") String operator);

    Integer insert(Community record);

    int insertSelective(Community record);

    Community selectByPrimaryKey(String communityId);

    int updateByPrimaryKeySelective(Community record);

    int updateByPrimaryKey(Community record);

    List<Community> findAll();

    Community findByCommunityId(@Param("communityId") String communityId);

    Integer updateCommunity(@Param("community") Community community);
}