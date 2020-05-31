package com.jason.news.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.AnswerDTO;
import com.jason.news.api.dto.AnswerQueryDTO;
import com.jason.news.dao.mapper.AnswerMapper;
import com.jason.news.dao.vo.Answer;
import com.jason.news.service.IAnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class AnswerService implements IAnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public Integer createAnswer(Answer answer) {
        answer.setAnswerId(UUID.randomUUID().toString().replace("-", ""));
        answer.setDelFlg(Boolean.FALSE);
        answer.setCreateTime(new Date());
        answer.setUpdateUser(answer.getCreateUser());
        answer.setUpdateTime(new Date());
        return answerMapper.insert(answer);
    }

    @Override
    public Integer deleteAnswer(String commentId, String operator) {
        return answerMapper.deleteByPrimaryKey(commentId, operator);
    }

    @Override
    public PageInfo<AnswerDTO> pageAnswerByParentId(AnswerQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        return PageInfo.of(answerMapper.findAll(queryDTO.getParentId()));
    }
}
