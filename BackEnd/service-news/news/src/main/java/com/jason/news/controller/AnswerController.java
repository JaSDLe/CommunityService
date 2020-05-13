package com.jason.news.controller;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.AnswerDTO;
import com.jason.news.api.dto.AnswerQueryDTO;
import com.jason.news.biz.IAnswerBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private IAnswerBiz answerBiz;

    @PostMapping("/createAnswer")
    Boolean createAnswer(@RequestBody AnswerDTO answerDTO) {
        return answerBiz.createAnswer(answerDTO);
    }

    @DeleteMapping("/deleteAnswer")
    Boolean deleteAnswer(@RequestParam("answerId") String answerId) {
        return answerBiz.deleteAnswer(answerId);
    }

    @GetMapping("/pageAnswerByParentId")
    PageInfo<AnswerDTO> pageAnswerByParentId(@RequestParam(value = "parentId", required = false) String parentId,
                                               @RequestParam("pageNum") Integer pageNum,
                                               @RequestParam("pageSize") Integer pageSize) {
        return answerBiz.pageAnswerByParentId(new AnswerQueryDTO(parentId, pageNum, pageSize));
    }
}
