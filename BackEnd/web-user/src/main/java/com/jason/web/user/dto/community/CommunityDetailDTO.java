package com.jason.web.user.dto.community;

import com.jason.member.api.dto.AccountSimpleDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CommunityDetailDTO {

    private String communityId;

    private String communityName;

    private String communityInfo;

    private String index;

    private Date createTime;

    private List<AccountSimpleDTO> adminList;

    private Integer population;
}
