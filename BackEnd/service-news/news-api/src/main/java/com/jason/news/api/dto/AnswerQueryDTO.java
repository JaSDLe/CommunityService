package com.jason.news.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnswerQueryDTO {

    private String answerId;

    private String parentId;

    private String communityId;

    private Integer pageNum;

    private Integer pageSize;

    public AnswerQueryDTO(String parentId, Integer pageNum, Integer pageSize) {
        this.parentId = parentId;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
