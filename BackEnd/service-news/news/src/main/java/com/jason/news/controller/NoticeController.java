package com.jason.news.controller;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.NoticeDTO;
import com.jason.news.api.dto.NoticeQueryDTO;
import com.jason.news.biz.INoticeBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private INoticeBiz noticeBiz;

    @GetMapping("/pageNotice")
    public PageInfo<NoticeDTO> pageNotice(@RequestParam(value = "communityId", required = false) String communityId,
                                          @RequestParam("pageNum") Integer pageNum,
                                          @RequestParam("pageSize") Integer pageSize) {
        return noticeBiz.pageNotice(new NoticeQueryDTO(communityId, pageNum, pageSize));
    }

    @GetMapping("/findByNoticeId")
    public NoticeDTO findByNoticeId(@RequestParam("noticeId") String noticeId) {
        return noticeBiz.findByNoticeId(noticeId);
    }
}
