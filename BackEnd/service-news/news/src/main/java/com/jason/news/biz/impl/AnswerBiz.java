package com.jason.news.biz.impl;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.AnswerDTO;
import com.jason.news.api.dto.AnswerQueryDTO;
import com.jason.news.biz.IAnswerBiz;
import com.jason.news.dao.vo.Answer;
import com.jason.news.service.IAnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AnswerBiz implements IAnswerBiz {

    @Autowired
    private IAnswerService answerService;

    @Override
    public Boolean createAnswer(AnswerDTO answerDTO) {
        return answerService.createAnswer(dTO2VO(answerDTO)) == 1;
    }

    @Override
    public Boolean deleteAnswer(String answerId, String operator) {
        return answerService.deleteAnswer(answerId, operator) == 1;
    }

    @Override
    public PageInfo<AnswerDTO> pageAnswerByParentId(AnswerQueryDTO queryDTO) {
        return answerService.pageAnswerByParentId(queryDTO);
    }

    private Answer dTO2VO(AnswerDTO answerDTO) {
        if (answerDTO == null) {
            return null;
        }
        Answer answer = new Answer();
        BeanUtils.copyProperties(answerDTO, answer);
        return answer;
    }

    private AnswerDTO vO2DTO(Answer answer) {
        if (answer == null) {
            return null;
        }
        AnswerDTO answerDTO = new AnswerDTO();
        BeanUtils.copyProperties(answer, answerDTO);
        return answerDTO;
    }
}
