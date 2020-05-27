package com.jason.member.api.service;

import com.github.pagehelper.PageInfo;
import com.jason.member.api.dto.ReadHistoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-member")
public interface IReadHistoryService {

    @RequestMapping(method = RequestMethod.POST, path = "/readHistory/add", consumes = "application/json")
    Boolean add(@RequestBody ReadHistoryDTO readHistoryDTO);

    @RequestMapping(method = RequestMethod.DELETE, path = "/readHistory/delete", consumes = "application/json")
    Boolean delete(@RequestBody ReadHistoryDTO readHistoryDTO);

    @RequestMapping(method = RequestMethod.GET, path = "/readHistory/pageReadHistory", consumes = "application/json")
    PageInfo<ReadHistoryDTO> pageReadHistory(@RequestParam(value = "accountId", required = false) String accountId, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);
}
