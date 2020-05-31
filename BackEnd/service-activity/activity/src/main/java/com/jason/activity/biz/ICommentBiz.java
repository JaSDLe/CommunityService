package com.jason.activity.biz;

import com.github.pagehelper.PageInfo;
import com.jason.activity.api.dto.CommentDTO;
import com.jason.activity.api.dto.CommentQueryDTO;

public interface ICommentBiz {

    Boolean createComment(CommentDTO commentDTO);

    Boolean deleteComment(String commentId, String operator);

    PageInfo<CommentDTO> pageCommentByParentId(CommentQueryDTO queryDTO);
}
