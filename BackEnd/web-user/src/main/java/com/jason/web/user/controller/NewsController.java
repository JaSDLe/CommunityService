package com.jason.web.user.controller;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.NewsDTO;
import com.jason.news.api.service.INewsService;
import com.jason.web.user.dto.ItemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsService newsService;

    @GetMapping("/pageNews")
    public ItemResult<PageInfo<NewsDTO>> pageNews(@RequestParam(value = "communityId", required = false) String communityId,
                                                  @RequestParam("pageNum") Integer pageNum,
                                                  @RequestParam("pageSize") Integer pageSize) {
        return new ItemResult<>(newsService.pageNews(communityId, pageNum, pageSize));
    }

    @GetMapping("/findByNewsId")
    public ItemResult<NewsDTO> findByNewsId(@RequestParam("newsId") String newsId) {
        return new ItemResult<>(newsService.findByNewsId(newsId));
    }
}
