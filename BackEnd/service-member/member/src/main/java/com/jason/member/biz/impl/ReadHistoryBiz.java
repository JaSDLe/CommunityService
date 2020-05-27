package com.jason.member.biz.impl;

import com.github.pagehelper.PageInfo;
import com.jason.member.api.dto.ReadHistoryDTO;
import com.jason.member.biz.IReadHistoryBiz;
import com.jason.member.dao.vo.ReadHistory;
import com.jason.member.service.IReadHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReadHistoryBiz implements IReadHistoryBiz {

    @Autowired
    private IReadHistoryService readHistoryService;

    @Override
    public Boolean add(ReadHistoryDTO readHistoryDTO) {
        return readHistoryService.add(dTO2VO(readHistoryDTO)) == 1;
    }

    @Override
    public Boolean delete(ReadHistoryDTO readHistoryDTO) {
        return readHistoryService.delete(dTO2VO(readHistoryDTO)) == 1;
    }

    @Override
    public PageInfo<ReadHistoryDTO> pageReadHistory(String accountId, Integer pageNum, Integer pageSize) {
        return readHistoryService.pageReadHistory(accountId, pageNum, pageSize);
    }

    private ReadHistory dTO2VO(ReadHistoryDTO readHistoryDTO) {
        if (readHistoryDTO == null) {
            return null;
        }
        ReadHistory readHistory = new ReadHistory();
        BeanUtils.copyProperties(readHistoryDTO, readHistory);
        return readHistory;
    }
}
