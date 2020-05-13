package com.jason.web.user.controller;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.NoticeDTO;
import com.jason.news.api.service.INoticeService;
import com.jason.web.user.dto.ItemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private INoticeService noticeService;

    @GetMapping("/pageNotice")
    public ItemResult<PageInfo<NoticeDTO>> pageNotice(@RequestParam(value = "communityId", required = false) String communityId,
                                                      @RequestParam("pageNum") Integer pageNum,
                                                      @RequestParam("pageSize") Integer pageSize) {
        return new ItemResult<>(noticeService.pageNotice(communityId, pageNum, pageSize));
    }

    @GetMapping("/findByNoticeId")
    public ItemResult<NoticeDTO> findByNoticeId(@RequestParam("noticeId") String noticeId) {
        return new ItemResult<>(noticeService.findByNoticeId(noticeId));
    }
}
