package com.jason.activity.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActivityQueryDTO {

    private String activityId;

    private String content;

    private String communityId;

    private Integer pageNum;

    private Integer pageSize;

    public ActivityQueryDTO(String communityId, Integer pageNum, Integer pageSize) {
        this.communityId = communityId;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
