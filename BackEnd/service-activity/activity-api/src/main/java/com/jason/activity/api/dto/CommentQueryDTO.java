package com.jason.activity.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentQueryDTO {

    private String parentId;

    private Integer pageNum;

    private Integer pageSize;

    public CommentQueryDTO(String parentId, Integer pageNum, Integer pageSize) {
        this.parentId = parentId;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
