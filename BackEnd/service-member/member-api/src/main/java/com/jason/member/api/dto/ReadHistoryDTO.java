package com.jason.member.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class ReadHistoryDTO {

    private String id;

    private Integer type;

    private String accountId;

    private String contentId;

    private Boolean delFlg;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    public ReadHistoryDTO(Integer type, String accountId, String contentId) {
        this.type = type;
        this.accountId = accountId;
        this.contentId = contentId;
    }
}
