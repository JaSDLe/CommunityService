package com.jason.news.service;

import com.jason.news.api.dto.NewsQueryDTO;
import com.jason.news.dao.vo.News;

import java.util.List;

public interface INewsService {

    List<News> pageNews(NewsQueryDTO queryDTO);

    News findByNewsId(String newsId);
}
