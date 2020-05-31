package com.jason.web.user.controller;

import com.github.pagehelper.PageInfo;
import com.jason.activity.api.dto.CommentDTO;
import com.jason.activity.api.service.ICommentService;
import com.jason.web.user.dto.ItemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @PostMapping("/createComment")
    public ItemResult<Boolean> createComment(@RequestBody CommentDTO commentDTO) {
        if (commentService.createComment(commentDTO)) {
            return new ItemResult<>(true, "创建成功");
        } else {
            return new ItemResult<>(false, "创建失败");
        }
    }

    @DeleteMapping("/deleteComment")
    public ItemResult<Boolean> deleteComment(@RequestParam("commentId") String commentId, @RequestParam("operator") String operator) {
        if (commentService.deleteComment(commentId, operator)) {
            return new ItemResult<>(true, "删除成功");
        } else {
            return new ItemResult<>(false, "删除失败");
        }
    }

    @GetMapping("/pageBaseComment")
    public ItemResult<PageInfo<CommentDTO>> pageBaseComment(@RequestParam(value = "activityId", required = false) String activityId,
                                                            @RequestParam("pageNum") Integer pageNum,
                                                            @RequestParam("pageSize") Integer pageSize) {
        return new ItemResult<>(commentService.pageCommentByParentId(activityId, pageNum, pageSize));
    }
}
