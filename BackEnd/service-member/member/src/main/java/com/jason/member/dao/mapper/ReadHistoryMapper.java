package com.jason.member.dao.mapper;

import com.jason.member.api.dto.ReadHistoryDTO;
import com.jason.member.dao.vo.ReadHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReadHistoryMapper {

    Integer deleteByPrimaryKey(@Param("id") String id, @Param("operator") String operator);

    Integer insert(ReadHistory record);

    Integer insertSelective(ReadHistory record);

    ReadHistory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ReadHistory record);

    int updateByPrimaryKey(ReadHistory record);

    List<ReadHistoryDTO> findAll(@Param("accountId") String accountId);
}