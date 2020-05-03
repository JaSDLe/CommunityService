package com.jason.news.biz;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.NewsDTO;
import com.jason.news.api.dto.NewsQueryDTO;

public interface INewsBiz {

    PageInfo<NewsDTO> pageNews(NewsQueryDTO queryDTO);

    NewsDTO findByNewsId(String newsId);
}
