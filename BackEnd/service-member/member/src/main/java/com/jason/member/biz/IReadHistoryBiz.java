package com.jason.member.biz;

import com.github.pagehelper.PageInfo;
import com.jason.member.api.dto.ReadHistoryDTO;

public interface IReadHistoryBiz {

    Boolean add(ReadHistoryDTO readHistoryDTO);

    Boolean delete(ReadHistoryDTO readHistoryDTO);

    PageInfo<ReadHistoryDTO> pageReadHistory(String accountId, Integer pageNum, Integer pageSize);
}
