package com.jason.message.controller;

import com.github.pagehelper.PageInfo;
import com.jason.message.biz.IMessageBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/activity")
public class MessageController {

    @Autowired
    private IMessageBiz messageBiz;

//    @GetMapping("/pageNews")
//    public PageInfo<NewsDTO> pageNews(@RequestParam(value = "communityId", required = false) String communityId,
//                                      @RequestParam("pageNum") Integer pageNum,
//                                      @RequestParam("pageSize") Integer pageSize) {
//        return messageBiz.pageNews(new NewsQueryDTO(communityId, pageNum, pageSize));
//    }

//    @GetMapping("/findByNewsId")
//    public NewsDTO findByNewsId(@RequestParam("newsId") String newsId) {
//        return messageBiz.findByNewsId(newsId);
//    }
}
