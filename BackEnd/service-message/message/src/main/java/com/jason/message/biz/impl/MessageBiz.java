package com.jason.message.biz.impl;

import com.jason.message.api.dto.MessageDTO;
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

//    @Override
//    public PageInfo<NewsDTO> pageNews(NewsQueryDTO queryDTO) {
//        return PageInfo.of(messageService.pageNews(queryDTO).stream().map(this::vO2DTO).collect(Collectors.toList()));
//    }

//    @Override
//    public NewsDTO findByNewsId(String newsId) {
//        return vO2DTO(messageService.findByNewsId(newsId));
//    }

    private MessageDTO vO2DTO(Message message) {
        if (message == null) {
            return null;
        }
        MessageDTO messageDTO = new MessageDTO();
        BeanUtils.copyProperties(message, messageDTO);
        return messageDTO;
    }
}
