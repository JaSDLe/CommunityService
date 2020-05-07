package com.jason.news.service;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.NewsDTO;
import com.jason.news.api.dto.NewsQueryDTO;
import com.jason.news.dao.vo.News;

public interface INewsService {

    PageInfo<NewsDTO> pageNews(NewsQueryDTO queryDTO);

    News findByNewsId(String newsId);
}
