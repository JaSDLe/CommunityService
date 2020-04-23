package com.jason.news.dao.mapper;


import com.jason.news.dao.vo.News;

public interface NewsMapper {

    int deleteByPrimaryKey(String newsId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(String newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);
}