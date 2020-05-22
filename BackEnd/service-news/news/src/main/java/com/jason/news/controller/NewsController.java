package com.jason.news.controller;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.NewsDTO;
import com.jason.news.api.dto.NewsQueryDTO;
import com.jason.news.biz.INewsBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/createNews")
    public Boolean createNews(@RequestBody NewsDTO newsDTO) {
        return newsBiz.createNews(newsDTO);
    }
}
