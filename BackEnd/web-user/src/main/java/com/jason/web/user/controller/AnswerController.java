package com.jason.web.user.controller;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.AnswerDTO;
import com.jason.news.api.service.IAnswerService;
import com.jason.web.user.dto.ItemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private IAnswerService answerService;

    @PostMapping("/createAnswer")
    public ItemResult<Boolean> createAnswer(@RequestBody AnswerDTO answerDTO) {
        if (answerService.createAnswer(answerDTO)) {
            return new ItemResult<>(true, "创建成功");
        } else {
            return new ItemResult<>(false, "创建失败");
        }
    }

    @DeleteMapping("/deleteAnswer")
    public ItemResult<Boolean> deleteAnswer(@RequestParam("answerId") String answerId) {
        if (answerService.deleteAnswer(answerId)) {
            return new ItemResult<>(true, "删除成功");
        } else {
            return new ItemResult<>(false, "删除失败");
        }
    }

    @GetMapping("/pageBaseAnswer")
    public ItemResult<PageInfo<AnswerDTO>> pageBaseAnswer(@RequestParam(value = "id", required = false) String id,
                                                          @RequestParam("pageNum") Integer pageNum,
                                                          @RequestParam("pageSize") Integer pageSize) {
        return new ItemResult<>(answerService.pageAnswerByParentId(id, pageNum, pageSize));
    }
}
