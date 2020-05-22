package com.jason.news.api.service;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.NoticeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-news")
public interface INoticeService {

    @RequestMapping(method = RequestMethod.GET, path = "/notice/pageNotice", consumes = "application/json")
    PageInfo<NoticeDTO> pageNotice(@RequestParam(value = "communityId", required = false) String communityId, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @RequestMapping(method = RequestMethod.GET, path = "/notice/findByNoticeId", consumes = "application/json")
    NoticeDTO findByNoticeId(@RequestParam("noticeId") String noticeId);

    @RequestMapping(method = RequestMethod.POST, path = "/notice/createNotice", consumes = "application/json")
    Boolean createNotice(@RequestBody NoticeDTO noticeDTO);
}
