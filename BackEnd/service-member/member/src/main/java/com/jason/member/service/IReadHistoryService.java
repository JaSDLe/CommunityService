package com.jason.member.service;

import com.github.pagehelper.PageInfo;
import com.jason.member.api.dto.ReadHistoryDTO;
import com.jason.member.dao.vo.ReadHistory;

public interface IReadHistoryService {

    Integer add(ReadHistory dTO2VO);

    Integer delete(ReadHistory dTO2VO);

    PageInfo<ReadHistoryDTO> pageReadHistory(String accountId, Integer pageNum, Integer pageSize);
}
