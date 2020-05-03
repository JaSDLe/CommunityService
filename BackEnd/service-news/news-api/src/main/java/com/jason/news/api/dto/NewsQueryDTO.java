package com.jason.news.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewsQueryDTO {

    private String newsId;

    private String title;

    private String communityId;

    private Integer pageNum;

    private Integer pageSize;

    public NewsQueryDTO(String communityId, Integer pageNum, Integer pageSize) {
        this.communityId = communityId;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
