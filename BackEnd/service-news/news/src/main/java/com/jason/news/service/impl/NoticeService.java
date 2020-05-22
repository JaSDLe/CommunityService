package com.jason.news.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.NoticeDTO;
import com.jason.news.api.dto.NoticeQueryDTO;
import com.jason.news.dao.mapper.NoticeMapper;
import com.jason.news.dao.vo.Notice;
import com.jason.news.service.INoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class NoticeService implements INoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public PageInfo<NoticeDTO> pageNotice(NoticeQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        return PageInfo.of(noticeMapper.findAll(queryDTO.getCommunityId()));
    }

    @Override
    public Notice findByNoticeId(String noticeId) {
        return noticeMapper.findByNoticeId(noticeId);
    }

    @Override
    public Integer createNews(Notice notice) {
        notice.setNoticeId(UUID.randomUUID().toString().replace("-", ""));
        notice.setDelFlg(Boolean.FALSE);
        notice.setCreateTime(new Date());
        notice.setUpdateUser(notice.getCreateUser());
        notice.setUpdateTime(new Date());
        return noticeMapper.insert(notice);
    }
}
