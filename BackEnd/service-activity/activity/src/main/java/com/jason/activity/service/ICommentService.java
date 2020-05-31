package com.jason.activity.service;

import com.github.pagehelper.PageInfo;
import com.jason.activity.api.dto.CommentDTO;
import com.jason.activity.api.dto.CommentQueryDTO;
import com.jason.activity.dao.vo.Comment;

public interface ICommentService {

    Integer createComment(Comment comment);

    Integer deleteComment(String commentId, String operator);

    PageInfo<CommentDTO> pageCommentByParentId(CommentQueryDTO queryDTO);
}
