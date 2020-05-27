package com.jason.member.controller;

import com.github.pagehelper.PageInfo;
import com.jason.member.api.dto.ReadHistoryDTO;
import com.jason.member.biz.IReadHistoryBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/readHistory")
public class ReadHistoryController {

    @Autowired
    private IReadHistoryBiz readHistoryBiz;

    @PostMapping("/add")
    Boolean add(@RequestBody ReadHistoryDTO readHistoryDTO) {
        return readHistoryBiz.add(readHistoryDTO);
    }

    @DeleteMapping("/delete")
    Boolean delete(@RequestBody ReadHistoryDTO readHistoryDTO) {
        return readHistoryBiz.delete(readHistoryDTO);
    }

    @GetMapping("/pageReadHistory")
    PageInfo<ReadHistoryDTO> pageReadHistory(@RequestParam(value = "accountId", required = false) String accountId,
                                             @RequestParam("pageNum") Integer pageNum,
                                             @RequestParam("pageSize") Integer pageSize) {
        return readHistoryBiz.pageReadHistory(accountId, pageNum, pageSize);
    }
}
