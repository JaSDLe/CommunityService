package com.jason.news.biz;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.NoticeDTO;
import com.jason.news.api.dto.NoticeQueryDTO;

public interface INoticeBiz {

    PageInfo<NoticeDTO> pageNotice(NoticeQueryDTO queryDTO);

    NoticeDTO findByNoticeId(String noticeId);

    Boolean createNotice(NoticeDTO noticeDTO);
}
