package com.jason.news.api.service;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.NewsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-news")
public interface INewsService {

    @RequestMapping(method = RequestMethod.GET, path = "/news/pageNews", consumes = "application/json")
    PageInfo<NewsDTO> pageNews(@RequestParam(value = "communityId", required = false) String communityId, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @RequestMapping(method = RequestMethod.GET, path = "/news/findByNewsId", consumes = "application/json")
    NewsDTO findByNewsId(@RequestParam("newsId") String newsId);

    @RequestMapping(method = RequestMethod.POST, path = "/news/createNews", consumes = "application/json")
    Boolean createNews(@RequestBody NewsDTO newsDTO);
}
