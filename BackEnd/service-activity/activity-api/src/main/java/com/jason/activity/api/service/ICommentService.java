package com.jason.activity.api.service;

import com.github.pagehelper.PageInfo;
import com.jason.activity.api.dto.CommentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-activity")
public interface ICommentService {

    @RequestMapping(method = RequestMethod.POST, path = "/comment/createComment", consumes = "application/json")
    Boolean createComment(@RequestBody CommentDTO commentDTO);

    @RequestMapping(method = RequestMethod.DELETE, path = "/comment/deleteComment", consumes = "application/json")
    Boolean deleteComment(@RequestParam("commentId") String commentId);

    @RequestMapping(method = RequestMethod.GET, path = "/comment/pageCommentByParentId", consumes = "application/json")
    PageInfo<CommentDTO> pageCommentByParentId(@RequestParam(value = "parentId", required = false) String parentId, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);
}
