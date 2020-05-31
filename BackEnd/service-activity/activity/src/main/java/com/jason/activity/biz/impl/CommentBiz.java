package com.jason.activity.biz.impl;

import com.github.pagehelper.PageInfo;
import com.jason.activity.api.dto.ActivityDTO;
import com.jason.activity.api.dto.CommentDTO;
import com.jason.activity.api.dto.CommentQueryDTO;
import com.jason.activity.biz.ICommentBiz;
import com.jason.activity.dao.vo.Activity;
import com.jason.activity.dao.vo.Comment;
import com.jason.activity.service.ICommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommentBiz implements ICommentBiz {

    @Autowired
    private ICommentService commentService;

    @Override
    public Boolean createComment(CommentDTO commentDTO) {
        return commentService.createComment(dTO2VO(commentDTO)) == 1;
    }

    @Override
    public Boolean deleteComment(String commentId, String operator) {
        return commentService.deleteComment(commentId, operator) == 1;
    }

    @Override
    public PageInfo<CommentDTO> pageCommentByParentId(CommentQueryDTO queryDTO) {
        return commentService.pageCommentByParentId(queryDTO);
    }

    private Comment dTO2VO(CommentDTO commentDTO) {
        if (commentDTO == null) {
            return null;
        }
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO, comment);
        return comment;
    }

    private ActivityDTO vO2DTO(Activity activity) {
        if (activity == null) {
            return null;
        }
        ActivityDTO activityDTO = new ActivityDTO();
        BeanUtils.copyProperties(activity, activityDTO);
        return activityDTO;
    }
}
