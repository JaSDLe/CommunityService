package com.jason.news.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class NoticeDTO {

    private String noticeId;

    private String title;

    private Date startTime;

    private Date endTime;

    private String communityId;

    private Boolean delFlg;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String content;

    private Integer replyNum;

    private String author;


}
