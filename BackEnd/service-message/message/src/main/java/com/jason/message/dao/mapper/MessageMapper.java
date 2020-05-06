package com.jason.message.dao.mapper;

import com.jason.message.dao.vo.Message;
import org.springframework.stereotype.Component;

@Component
public interface MessageMapper {

    int deleteByPrimaryKey(String id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}