package com.jason.web.admin.controller;

import com.jason.news.api.dto.NewsDTO;
import com.jason.news.api.service.INewsService;
import com.jason.web.admin.dto.ItemResult;
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

    @PostMapping("/createNews")
    public ItemResult<Boolean> createNews(@RequestBody NewsDTO newsDTO) {
        if (newsService.createNews(newsDTO)) {
            return new ItemResult<>(true, "创建成功");
        } else {
            return new ItemResult<>(false, "创建失败");
        }
    }
}
