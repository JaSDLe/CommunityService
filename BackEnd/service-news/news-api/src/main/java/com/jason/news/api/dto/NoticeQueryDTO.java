package com.jason.news.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoticeQueryDTO {

    private String noticeId;

    private String title;

    private String communityId;

    private Integer pageNum;

    private Integer pageSize;

    public NoticeQueryDTO(String communityId, Integer pageNum, Integer pageSize) {
        this.communityId = communityId;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
