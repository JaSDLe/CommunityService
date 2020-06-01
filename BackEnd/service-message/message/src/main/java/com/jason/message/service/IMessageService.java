package com.jason.message.service;

import com.github.pagehelper.PageInfo;
import com.jason.message.api.dto.MessageDTO;
import com.jason.message.api.dto.MessageQueryDTO;
import com.jason.message.dao.vo.Message;

public interface IMessageService {

    PageInfo<MessageDTO> pageMessage(MessageQueryDTO queryDTO);

    Message findByMessageId(String messageId);
}
