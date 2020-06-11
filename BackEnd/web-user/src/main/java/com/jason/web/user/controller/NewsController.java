package com.jason.web.user.controller;

import com.github.pagehelper.PageInfo;
import com.jason.member.api.dto.ReadHistoryDTO;
import com.jason.member.api.enums.ReadHistoryTypeEnum;
import com.jason.member.api.service.IAccountDetailService;
import com.jason.member.api.service.IReadHistoryService;
import com.jason.news.api.dto.NewsDTO;
import com.jason.news.api.dto.NewsQueryDTO;
import com.jason.news.api.service.INewsService;
import com.jason.web.user.dto.ItemResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsService newsService;

    @Autowired
    private IReadHistoryService readHistoryService;

    @Autowired
    private IAccountDetailService accountDetailService;

    @PostMapping("/pageNews")
    public ItemResult<PageInfo<NewsDTO>> pageNews(@RequestBody NewsQueryDTO queryDTO) {
        if (StringUtils.isBlank(queryDTO.getCommunityId())) {
            return new ItemResult<>();
        }
        return new ItemResult<>(newsService.pageNews(queryDTO));
    }

    @GetMapping("/findByNewsId")
    public ItemResult<NewsDTO> findByNewsId(@RequestParam("newsId") String newsId, @RequestParam("operator") String operator) {
        NewsDTO result = newsService.findByNewsId(newsId);
        if (result != null) {
            result.setAuthor(accountDetailService.findSimpleAccountByAccountId(result.getCreateUser()).getNickname());
            readHistoryService.add(new ReadHistoryDTO(ReadHistoryTypeEnum.NEWS.getKey(), operator, newsId));
        }
        return new ItemResult<>(result);
    }
}
