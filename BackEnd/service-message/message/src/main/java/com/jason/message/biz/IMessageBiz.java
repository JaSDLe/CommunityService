package com.jason.message.biz;

import com.github.pagehelper.PageInfo;
import com.jason.message.api.dto.MessageDTO;
import com.jason.message.api.dto.MessageQueryDTO;

public interface IMessageBiz {

    PageInfo<MessageDTO> pageMessage(MessageQueryDTO queryDTO);

    MessageDTO findByMessageId(String messageId);
}
