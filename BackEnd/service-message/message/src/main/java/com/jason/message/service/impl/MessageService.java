package com.jason.message.service.impl;

import com.github.pagehelper.PageHelper;
import com.jason.message.dao.mapper.MessageMapper;
import com.jason.message.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MessageService implements IMessageService {

    @Autowired
    private MessageMapper messageMapper;

//    @Override
//    public List<News> pageNews(NewsQueryDTO queryDTO) {
//        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
//        return messageMapper.findAll(queryDTO.getCommunityId());
//    }

//    @Override
//    public News findByNewsId(String newsId) {
//        return messageMapper.findByNewsId(newsId);
//    }
}
