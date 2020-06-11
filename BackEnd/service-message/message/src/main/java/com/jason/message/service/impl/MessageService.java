package com.jason.message.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.message.api.dto.MessageDTO;
import com.jason.message.api.dto.MessageQueryDTO;
import com.jason.message.dao.mapper.MessageMapper;
import com.jason.message.dao.vo.Message;
import com.jason.message.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class MessageService implements IMessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public PageInfo<MessageDTO> pageMessage(MessageQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        return PageInfo.of(messageMapper.findAll(queryDTO.getAccountId()));
    }

    @Override
    public Message findByMessageId(String messageId) {
        return messageMapper.findByMessageId(messageId);
    }

    @Override
    public Integer createMessage(Message message) {
        message.setId(UUID.randomUUID().toString().replace("-", ""));
        message.setDelFlg(Boolean.FALSE);
        message.setCreateUser(message.getSenderId());
        message.setUpdateUser(message.getSenderId());
        message.setCreateTime(new Date());
        message.setUpdateTime(new Date());
        return messageMapper.insert(message);
    }
}
