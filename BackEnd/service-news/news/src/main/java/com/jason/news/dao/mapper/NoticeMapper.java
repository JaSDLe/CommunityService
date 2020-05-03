package com.jason.news.dao.mapper;


import com.jason.news.dao.vo.Notice;
import org.springframework.stereotype.Component;

@Component
public interface NoticeMapper {

    int deleteByPrimaryKey(String noticeId);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(String noticeId);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);
}