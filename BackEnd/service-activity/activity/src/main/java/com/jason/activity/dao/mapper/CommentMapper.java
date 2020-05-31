package com.jason.activity.dao.mapper;

import com.jason.activity.api.dto.CommentDTO;
import com.jason.activity.dao.vo.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentMapper {

    Integer deleteByPrimaryKey(@Param("commentId") String commentId, @Param("operator") String operator);

    Integer insert(Comment record);

    Integer insertSelective(Comment record);

    Comment selectByPrimaryKey(String commentId);

    Integer updateByPrimaryKeySelective(Comment record);

    Integer updateByPrimaryKey(Comment record);

    List<CommentDTO> findAll(@Param("parentId") String parentId);
}