package com.jason.web.user.controller;

import com.github.pagehelper.PageInfo;
import com.jason.member.api.dto.ReadHistoryDTO;
import com.jason.member.api.enums.ReadHistoryTypeEnum;
import com.jason.member.api.service.IAccountDetailService;
import com.jason.member.api.service.IReadHistoryService;
import com.jason.message.api.dto.MessageDTO;
import com.jason.message.api.service.IMessageService;
import com.jason.web.user.dto.ItemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IReadHistoryService readHistoryService;

    @Autowired
    private IAccountDetailService accountDetailService;

    @GetMapping("/pageNews")
    public ItemResult<PageInfo<MessageDTO>> pageNews(@RequestParam("accountId") String accountId,
                                                     @RequestParam("pageNum") Integer pageNum,
                                                     @RequestParam("pageSize") Integer pageSize) {
        return new ItemResult<>(messageService.pageMessage(accountId, pageNum, pageSize));
    }

    @GetMapping("/findByNewsId")
    public ItemResult<MessageDTO> findByNewsId(@RequestParam("messageId") String messageId, @RequestParam("operator") String operator) {
        MessageDTO result = messageService.findByMessageId(messageId);
        if (result != null) {
            readHistoryService.add(new ReadHistoryDTO(ReadHistoryTypeEnum.MESSAGE.getKey(), operator, messageId));
        }
        return new ItemResult<>(result);
    }
}
