package com.jason.activity.dao.mapper;


import com.jason.activity.dao.vo.Comment;

public interface CommentMapper {

    int deleteByPrimaryKey(String commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(String commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}