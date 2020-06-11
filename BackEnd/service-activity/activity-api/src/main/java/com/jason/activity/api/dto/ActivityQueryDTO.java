package com.jason.activity.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActivityQueryDTO {

    private String content;

    private String communityId;

    private Integer pageNum;

    private Integer pageSize;
}
