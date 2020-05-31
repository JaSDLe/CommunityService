package com.jason.activity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.activity.api.dto.CommentDTO;
import com.jason.activity.api.dto.CommentQueryDTO;
import com.jason.activity.dao.mapper.CommentMapper;
import com.jason.activity.dao.vo.Comment;
import com.jason.activity.service.ICommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Integer createComment(Comment comment) {
        comment.setCommentId(UUID.randomUUID().toString().replace("-", ""));
        comment.setDelFlg(Boolean.FALSE);
        comment.setCreateTime(new Date());
        comment.setUpdateUser(comment.getCreateUser());
        comment.setUpdateTime(new Date());
        return commentMapper.insert(comment);
    }

    @Override
    public Integer deleteComment(String commentId, String operator) {
        return commentMapper.deleteByPrimaryKey(commentId, operator);
    }

    @Override
    public PageInfo<CommentDTO> pageCommentByParentId(CommentQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        return PageInfo.of(commentMapper.findAll(queryDTO.getParentId()));
    }
}
