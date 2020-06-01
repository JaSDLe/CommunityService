package com.jason.message.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageQueryDTO {

    private String accountId;

    private Integer pageNum;

    private Integer pageSize;

    public MessageQueryDTO(String accountId, Integer pageNum, Integer pageSize) {
        this.accountId = accountId;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
