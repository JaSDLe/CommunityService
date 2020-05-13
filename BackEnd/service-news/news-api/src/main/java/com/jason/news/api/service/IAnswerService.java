package com.jason.news.api.service;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.AnswerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-news")
public interface IAnswerService {

    @RequestMapping(method = RequestMethod.POST, path = "/answer/createAnswer", consumes = "application/json")
    Boolean createAnswer(@RequestBody AnswerDTO answerDTO);

    @RequestMapping(method = RequestMethod.DELETE, path = "/answer/deleteAnswer", consumes = "application/json")
    Boolean deleteAnswer(@RequestParam("answerId") String answerId);

    @RequestMapping(method = RequestMethod.GET, path = "/answer/pageAnswerByParentId", consumes = "application/json")
    PageInfo<AnswerDTO> pageAnswerByParentId(@RequestParam(value = "parentId", required = false) String parentId, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);
}
