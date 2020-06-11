package com.jason.message.biz.impl;

import com.github.pagehelper.PageInfo;
import com.jason.message.api.dto.MessageDTO;
import com.jason.message.api.dto.MessageQueryDTO;
import com.jason.message.biz.IMessageBiz;
import com.jason.message.dao.vo.Message;
import com.jason.message.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageBiz implements IMessageBiz {

    @Autowired
    private IMessageService messageService;

    @Override
    public PageInfo<MessageDTO> pageMessage(MessageQueryDTO queryDTO) {
        return messageService.pageMessage(queryDTO);
    }

    @Override
    public MessageDTO findByMessageId(String messageId) {
        return vO2DTO(messageService.findByMessageId(messageId));
    }

    @Override
    public Boolean createMessage(MessageDTO messageDTO) {
        return messageService.createMessage(dTO2VO(messageDTO)) == 1;
    }

    private MessageDTO vO2DTO(Message message) {
        if (message == null) {
            return null;
        }
        MessageDTO messageDTO = new MessageDTO();
        BeanUtils.copyProperties(message, messageDTO);
        return messageDTO;
    }

    private Message dTO2VO(MessageDTO messageDTO) {
        if (messageDTO == null) {
            return null;
        }
        Message message = new Message();
        BeanUtils.copyProperties(messageDTO, message);
        return message;
    }
}
