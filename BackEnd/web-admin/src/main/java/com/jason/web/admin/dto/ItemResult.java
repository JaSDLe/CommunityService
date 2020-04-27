package com.jason.web.admin.dto;

import lombok.Data;

@Data
public class ItemResult<T> {

    private boolean success;

    private String code;

    private String description;

    private T data;

    public ItemResult() {
    }

    public ItemResult(T data) {
        this.setSuccess(Boolean.TRUE);
        this.setData(data);
    }

    public ItemResult(T data, String description) {
        this.setSuccess(Boolean.TRUE);
        this.setData(data);
        this.setDescription(description);
    }

    public ItemResult(String errorCode, String description) {
        this.setSuccess(Boolean.FALSE);
        this.setCode(errorCode);
        this.setDescription(description);
    }
}
