package com.jason.community.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommunityDTO {

    private String communityId;

    private String communityName;

    private String communityInfo;

    private String index;

    private Date createTime;

    private String updateUser;
}
