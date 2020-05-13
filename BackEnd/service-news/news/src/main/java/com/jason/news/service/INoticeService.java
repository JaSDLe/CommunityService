package com.jason.news.service;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.NoticeDTO;
import com.jason.news.api.dto.NoticeQueryDTO;
import com.jason.news.dao.vo.Notice;

public interface INoticeService {

    PageInfo<NoticeDTO> pageNotice(NoticeQueryDTO queryDTO);

    Notice findByNoticeId(String noticeId);
}
