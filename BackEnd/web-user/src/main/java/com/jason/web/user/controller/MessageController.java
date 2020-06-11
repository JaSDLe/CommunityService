package com.jason.web.user.controller;

import com.github.pagehelper.PageInfo;
import com.jason.member.api.dto.ReadHistoryDTO;
import com.jason.member.api.enums.ReadHistoryTypeEnum;
import com.jason.member.api.service.IAccountDetailService;
import com.jason.member.api.service.IAccountService;
import com.jason.member.api.service.IReadHistoryService;
import com.jason.message.api.dto.MessageDTO;
import com.jason.message.api.service.IMessageService;
import com.jason.web.user.dto.ItemResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
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

    @Autowired
    private IAccountService accountService;

    @GetMapping("/pageMessage")
    public ItemResult<PageInfo<MessageDTO>> pageMessage(@RequestParam("accountId") String accountId,
                                                        @RequestParam("pageNum") Integer pageNum,
                                                        @RequestParam("pageSize") Integer pageSize) {
        return new ItemResult<>(messageService.pageMessage(accountId, pageNum, pageSize));
    }

    @GetMapping("/findByMessageId")
    public ItemResult<MessageDTO> findByMessageId(@RequestParam("messageId") String messageId, @RequestParam("operator") String operator) {
        MessageDTO result = messageService.findByMessageId(messageId);
        if (result != null) {
            readHistoryService.add(new ReadHistoryDTO(ReadHistoryTypeEnum.MESSAGE.getKey(), operator, messageId));
        }
        return new ItemResult<>(result);
    }

    @PostMapping("/createMessage")
    public ItemResult<Boolean> createMessage(@RequestBody MessageDTO messageDTO) {
        String accountId = accountService.findAccountIdByUsername(messageDTO.getReceiverId());
        if (StringUtils.isNotBlank(accountId)) {
            messageDTO.setReceiverId(accountId);
            if (messageService.createMessage(messageDTO)) {
                return new ItemResult<>(true, "创建成功");
            } else {
                return new ItemResult<>(false, "创建失败");
            }
        } else {
            return new ItemResult<>(false, "用户名不存在");
        }
    }
}
