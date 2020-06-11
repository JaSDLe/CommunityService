package com.jason.web.user.controller;

import com.github.pagehelper.PageInfo;
import com.jason.member.api.dto.ReadHistoryDTO;
import com.jason.member.api.enums.ReadHistoryTypeEnum;
import com.jason.member.api.service.IAccountDetailService;
import com.jason.member.api.service.IReadHistoryService;
import com.jason.news.api.dto.NoticeDTO;
import com.jason.news.api.service.INoticeService;
import com.jason.web.user.dto.ItemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private INoticeService noticeService;

    @Autowired
    private IReadHistoryService readHistoryService;

    @Autowired
    private IAccountDetailService accountDetailService;

    @GetMapping("/pageNotice")
    public ItemResult<PageInfo<NoticeDTO>> pageNotice(@RequestParam(value = "communityId", required = false) String communityId,
                                                      @RequestParam("pageNum") Integer pageNum,
                                                      @RequestParam("pageSize") Integer pageSize) {
        return new ItemResult<>(noticeService.pageNotice(communityId, pageNum, pageSize));
    }

    @GetMapping("/findByNoticeId")
    public ItemResult<NoticeDTO> findByNoticeId(@RequestParam("noticeId") String noticeId, @RequestParam("operator") String operator) {
        NoticeDTO result = noticeService.findByNoticeId(noticeId);
        if (result != null) {
            result.setAuthor(accountDetailService.findSimpleAccountByAccountId(result.getCreateUser()).getNickname());
            readHistoryService.add(new ReadHistoryDTO(ReadHistoryTypeEnum.NOTICE.getKey(), operator, noticeId));
        }
        return new ItemResult<>(result);
    }
}
