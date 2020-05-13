package com.jason.news.biz.impl;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.NoticeDTO;
import com.jason.news.api.dto.NoticeQueryDTO;
import com.jason.news.biz.INoticeBiz;
import com.jason.news.dao.vo.Notice;
import com.jason.news.service.INoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NoticeBiz implements INoticeBiz {

    @Autowired
    private INoticeService noticeService;

    @Override
    public PageInfo<NoticeDTO> pageNotice(NoticeQueryDTO queryDTO) {
        return noticeService.pageNotice(queryDTO);
    }

    @Override
    public NoticeDTO findByNoticeId(String noticeId) {
        return vO2DTO(noticeService.findByNoticeId(noticeId));
    }

    private NoticeDTO vO2DTO(Notice notice) {
        if (notice == null) {
            return null;
        }
        NoticeDTO noticeDTO = new NoticeDTO();
        BeanUtils.copyProperties(notice, noticeDTO);
        return noticeDTO;
    }
}
