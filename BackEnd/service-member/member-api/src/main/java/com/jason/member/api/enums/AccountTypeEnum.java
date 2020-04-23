package com.jason.member.api.enums;

import lombok.Getter;

@Getter
public enum AccountTypeEnum {

    SUPER_ADMINISTRATOR(1, "超级管理员"),
    ADMINISTRATOR(2, "社区管理员"),
    RESIDENT(3, "社区居民");

    private Integer key;

    private String value;

    AccountTypeEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValueByKey(Integer key) {
        for (AccountTypeEnum item : values()) {
            if (item.getKey().equals(key)) {
                return item.getValue();
            }
        }
        return null;
    }
}
