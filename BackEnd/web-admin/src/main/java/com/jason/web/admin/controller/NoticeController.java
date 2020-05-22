package com.jason.web.admin.controller;

import com.jason.news.api.dto.NoticeDTO;
import com.jason.news.api.service.INoticeService;
import com.jason.web.admin.dto.ItemResult;
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

    @PostMapping("/createNotice")
    public ItemResult<Boolean> createNotice(@RequestBody NoticeDTO noticeDTO) {
        if (noticeService.createNotice(noticeDTO)) {
            return new ItemResult<>(true, "创建成功");
        } else {
            return new ItemResult<>(false, "创建失败");
        }
    }
}
