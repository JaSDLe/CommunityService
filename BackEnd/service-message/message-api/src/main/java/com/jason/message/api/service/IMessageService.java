package com.jason.message.api.service;

import com.github.pagehelper.PageInfo;
import com.jason.message.api.dto.MessageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-message")
public interface IMessageService {

    @RequestMapping(method = RequestMethod.GET, path = "/message/pageNews", consumes = "application/json")
    PageInfo<MessageDTO> pageNews(@RequestParam(value = "communityId", required = false) String communityId, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @RequestMapping(method = RequestMethod.GET, path = "/message/findByNewsId", consumes = "application/json")
    MessageDTO findByNewsId(@RequestParam("newsId") String newsId);
}
