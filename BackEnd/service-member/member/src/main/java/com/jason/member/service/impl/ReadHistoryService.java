package com.jason.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.member.api.dto.ReadHistoryDTO;
import com.jason.member.dao.mapper.ReadHistoryMapper;
import com.jason.member.dao.vo.ReadHistory;
import com.jason.member.service.IReadHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class ReadHistoryService implements IReadHistoryService {

    @Autowired
    private ReadHistoryMapper readHistoryMapper;

    @Override
    public Integer add(ReadHistory readHistory) {
        readHistory.setId(UUID.randomUUID().toString().replace("-", ""));
        readHistory.setDelFlg(Boolean.FALSE);
        readHistory.setCreateUser(readHistory.getAccountId());
        readHistory.setCreateTime(new Date());
        readHistory.setUpdateUser(readHistory.getAccountId());
        readHistory.setUpdateTime(new Date());
        return readHistoryMapper.insertSelective(readHistory);
    }

    @Override
    public Integer delete(ReadHistory readHistory) {
        return readHistoryMapper.deleteByPrimaryKey(readHistory.getId(), readHistory.getUpdateUser());
    }

    @Override
    public PageInfo<ReadHistoryDTO> pageReadHistory(String accountId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return PageInfo.of(readHistoryMapper.findAll(accountId));
    }
}
