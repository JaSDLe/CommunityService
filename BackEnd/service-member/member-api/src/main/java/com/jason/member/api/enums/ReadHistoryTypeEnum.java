package com.jason.member.api.enums;

import lombok.Getter;

@Getter
public enum ReadHistoryTypeEnum {

    NEWS(1, "新闻"),
    NOTICE(2, "公告"),
    ACTIVITY(3, "动态"),
    COMMUNITY(4, "社区"),
    ACCOUNT(5, "账号"),
    MESSAGE(6, "私信");

    private Integer key;

    private String value;

    ReadHistoryTypeEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValueByKey(Integer key) {
        for (ReadHistoryTypeEnum item : values()) {
            if (item.getKey().equals(key)) {
                return item.getValue();
            }
        }
        return null;
    }
}
