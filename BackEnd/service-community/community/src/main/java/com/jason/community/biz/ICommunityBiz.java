package com.jason.community.biz;

import com.jason.community.api.dto.CommunityDTO;

import java.util.List;

public interface ICommunityBiz {

    List<CommunityDTO> findAll();

    CommunityDTO findByCommunityId(String communityId);

    Boolean createCommunity(CommunityDTO communityDTO);

    Boolean updateCommunity(CommunityDTO communityDTO);

    Boolean deleteCommunity(String communityId, String operator);
}
