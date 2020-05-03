package com.jason.news.dao.mapper;


import com.jason.news.dao.vo.News;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NewsMapper {

    int deleteByPrimaryKey(String newsId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(String newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);

    News findByNewsId(@Param("newsId") String newsId);

    List<News> findAll(@Param("communityId") String communityId);
}