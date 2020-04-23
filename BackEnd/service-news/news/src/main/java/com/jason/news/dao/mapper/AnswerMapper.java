package com.jason.news.dao.mapper;


import com.jason.news.dao.vo.Answer;

public interface AnswerMapper {

    int deleteByPrimaryKey(String answerId);

    int insert(Answer record);

    int insertSelective(Answer record);

    Answer selectByPrimaryKey(String answerId);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);
}