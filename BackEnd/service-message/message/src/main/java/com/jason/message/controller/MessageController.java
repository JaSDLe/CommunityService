package com.jason.message.controller;

import com.github.pagehelper.PageInfo;
import com.jason.message.api.dto.MessageDTO;
import com.jason.message.api.dto.MessageQueryDTO;
import com.jason.message.biz.IMessageBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IMessageBiz messageBiz;

    @GetMapping("/pageMessage")
    public PageInfo<MessageDTO> pageMessage(@RequestParam("accountId") String accountId,
                                            @RequestParam("pageNum") Integer pageNum,
                                            @RequestParam("pageSize") Integer pageSize) {
        return messageBiz.pageMessage(new MessageQueryDTO(accountId, pageNum, pageSize));
    }

    @GetMapping("/findByMessageId")
    public MessageDTO findByMessageId(@RequestParam("messageId") String messageId) {
        return messageBiz.findByMessageId(messageId);
    }
}
