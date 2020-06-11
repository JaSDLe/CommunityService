package com.jason.web.user.controller;

import com.github.pagehelper.PageInfo;
import com.jason.member.api.dto.ReadHistoryDTO;
import com.jason.member.api.service.IReadHistoryService;
import com.jason.web.user.dto.ItemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/readHistory")
public class ReadHistoryController {

    @Autowired
    private IReadHistoryService readHistoryService;

    @GetMapping("/pageNews")
    public ItemResult<PageInfo<ReadHistoryDTO>> pageNews(@RequestParam(value = "accountId", required = false) String accountId,
                                                         @RequestParam("pageNum") Integer pageNum,
                                                         @RequestParam("pageSize") Integer pageSize) {
        return new ItemResult<>(readHistoryService.pageReadHistory(accountId, pageNum, pageSize));
    }

    @DeleteMapping("/delete")
    public ItemResult<Boolean> delete(@RequestBody ReadHistoryDTO readHistoryDTO) {
        if (readHistoryService.delete(readHistoryDTO)) {
            return new ItemResult<>(true, "删除成功");
        } else {
            return new ItemResult<>(false, "删除失败");
        }
    }
}
