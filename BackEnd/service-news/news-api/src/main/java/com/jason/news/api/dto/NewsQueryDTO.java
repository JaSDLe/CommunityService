package com.jason.news.api.dto;

import lombok.Data;

@Data
public class NewsQueryDTO {

    private String title;

    private String communityId;

    private Integer pageNum;

    private Integer pageSize;
}
