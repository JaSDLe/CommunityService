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

@Slf4j
@Service
public class NewsService implements INewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public PageInfo<NewsDTO> pageNews(NewsQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
//        return newsMapper.findAll(queryDTO.getCommunityId());
        return PageInfo.of(newsMapper.findAll(queryDTO.getCommunityId()));
    }

    @Override
    public News findByNewsId(String newsId) {
        return newsMapper.findByNewsId(newsId);
    }
}
