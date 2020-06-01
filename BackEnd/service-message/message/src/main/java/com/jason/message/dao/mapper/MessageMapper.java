package com.jason.message.dao.mapper;

import com.jason.message.api.dto.MessageDTO;
import com.jason.message.dao.vo.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MessageMapper {

    int deleteByPrimaryKey(String id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    List<MessageDTO> findAll(@Param("accountId") String accountId);

    Message findByMessageId(@Param("messageId") String messageId);
}