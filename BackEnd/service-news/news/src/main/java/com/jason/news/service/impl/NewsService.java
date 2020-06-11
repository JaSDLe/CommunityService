package com.jason.news.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.NewsDTO;
import com.jason.news.api.dto.NewsQueryDTO;
import com.jason.news.dao.mapper.NewsMapper;
import com.jason.news.dao.vo.News;
import com.jason.news.service.INewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class NewsService implements INewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public PageInfo<NewsDTO> pageNews(NewsQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
//        return newsMapper.findAll(queryDTO.getCommunityId());
        return PageInfo.of(newsMapper.findAll(queryDTO));
    }

    @Override
    public News findByNewsId(String newsId) {
        return newsMapper.findByNewsId(newsId);
    }

    @Override
    public Integer createNews(News news) {
        news.setNewsId(UUID.randomUUID().toString().replace("-", ""));
        news.setReplyNum(0);
        news.setDelFlg(Boolean.FALSE);
        news.setCreateTime(new Date());
        news.setUpdateUser(news.getCreateUser());
        news.setUpdateTime(new Date());
        return newsMapper.insert(news);
    }
}
