package com.jason.message.api.service;

import com.github.pagehelper.PageInfo;
import com.jason.message.api.dto.MessageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-message")
public interface IMessageService {

    @RequestMapping(method = RequestMethod.GET, path = "/message/pageMessage", consumes = "application/json")
    PageInfo<MessageDTO> pageMessage(@RequestParam("accountId") String accountId, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @RequestMapping(method = RequestMethod.GET, path = "/message/findByMessageId", consumes = "application/json")
    MessageDTO findByMessageId(@RequestParam("messageId") String messageId);
}
