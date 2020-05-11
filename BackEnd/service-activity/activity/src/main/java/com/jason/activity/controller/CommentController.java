package com.jason.activity.controller;

import com.github.pagehelper.PageInfo;
import com.jason.activity.api.dto.CommentDTO;
import com.jason.activity.api.dto.CommentQueryDTO;
import com.jason.activity.biz.ICommentBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private ICommentBiz commentBiz;

    @PostMapping("/createComment")
    Boolean createComment(@RequestBody CommentDTO commentDTO) {
        return commentBiz.createComment(commentDTO);
    }

    @DeleteMapping("/deleteComment")
    Boolean deleteComment(@RequestParam("commentId") String commentId) {
        return commentBiz.deleteComment(commentId);
    }

    @GetMapping("/pageCommentByParentId")
    PageInfo<CommentDTO> pageCommentByParentId(@RequestParam(value = "parentId", required = false) String parentId,
                                         @RequestParam("pageNum") Integer pageNum,
                                         @RequestParam("pageSize") Integer pageSize) {
        return commentBiz.pageCommentByParentId(new CommentQueryDTO(parentId, pageNum, pageSize));
    }
}
