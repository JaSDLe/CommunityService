package com.jason.member.dao.mapper;

import com.jason.member.dao.vo.ReadHistory;
import org.springframework.stereotype.Component;

@Component
public interface ReadHistoryMapper {

    int deleteByPrimaryKey(String id);

    int insert(ReadHistory record);

    int insertSelective(ReadHistory record);

    ReadHistory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ReadHistory record);

    int updateByPrimaryKey(ReadHistory record);
}