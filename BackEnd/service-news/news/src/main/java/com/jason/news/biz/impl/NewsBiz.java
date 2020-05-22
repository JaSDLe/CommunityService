package com.jason.news.biz.impl;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.NewsDTO;
import com.jason.news.api.dto.NewsQueryDTO;
import com.jason.news.biz.INewsBiz;
import com.jason.news.dao.vo.News;
import com.jason.news.service.INewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NewsBiz implements INewsBiz {

    @Autowired
    private INewsService newsService;

    @Override
    public PageInfo<NewsDTO> pageNews(NewsQueryDTO queryDTO) {
//        return PageInfo.of(newsService.pageNews(queryDTO).stream().map(this::vO2DTO).collect(Collectors.toList()));
        return newsService.pageNews(queryDTO);
    }

    @Override
    public NewsDTO findByNewsId(String newsId) {
        return vO2DTO(newsService.findByNewsId(newsId));
    }

    @Override
    public Boolean createNews(NewsDTO newsDTO) {
        return newsService.createNews(dTO2VO(newsDTO)) == 1;
    }

    private NewsDTO vO2DTO(News news) {
        if (news == null) {
            return null;
        }
        NewsDTO newsDTO = new NewsDTO();
        BeanUtils.copyProperties(news, newsDTO);
        return newsDTO;
    }

    private News dTO2VO(NewsDTO newsDTO) {
        if (newsDTO == null) {
            return null;
        }
        News news = new News();
        BeanUtils.copyProperties(newsDTO, news);
        return news;
    }
}
