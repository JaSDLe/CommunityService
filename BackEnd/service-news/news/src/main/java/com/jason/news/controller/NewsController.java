package com.jason.news.controller;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.NewsDTO;
import com.jason.news.api.dto.NewsQueryDTO;
import com.jason.news.biz.INewsBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsBiz newsBiz;

    @GetMapping("/pageNews")
    public PageInfo<NewsDTO> pageNews(@RequestParam(value = "communityId", required = false) String communityId,
                                      @RequestParam("pageNum") Integer pageNum,
                                      @RequestParam("pageSize") Integer pageSize) {
        return newsBiz.pageNews(new NewsQueryDTO(communityId, pageNum, pageSize));
    }

    @GetMapping("/findByNewsId")
    public NewsDTO findByNewsId(@RequestParam("newsId") String newsId) {
        return newsBiz.findByNewsId(newsId);
    }
}
