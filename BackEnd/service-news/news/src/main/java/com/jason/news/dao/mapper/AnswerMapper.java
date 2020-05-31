package com.jason.news.dao.mapper;


import com.jason.news.api.dto.AnswerDTO;
import com.jason.news.dao.vo.Answer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AnswerMapper {

    Integer deleteByPrimaryKey(@Param("answerId") String answerId, @Param("operator") String operator);

    Integer insert(Answer record);

    Integer insertSelective(Answer record);

    Answer selectByPrimaryKey(String answerId);

    Integer updateByPrimaryKeySelective(Answer record);

    Integer updateByPrimaryKey(Answer record);

    List<AnswerDTO> findAll(@Param("parentId") String parentId);
}