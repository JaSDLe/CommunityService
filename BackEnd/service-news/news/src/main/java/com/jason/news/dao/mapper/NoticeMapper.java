package com.jason.news.dao.mapper;


import com.jason.news.api.dto.NoticeDTO;
import com.jason.news.dao.vo.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NoticeMapper {

    int deleteByPrimaryKey(String noticeId);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(String noticeId);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);

    List<NoticeDTO> findAll(@Param("communityId") String communityId);

    Notice findByNoticeId(@Param("noticeId") String noticeId);
}