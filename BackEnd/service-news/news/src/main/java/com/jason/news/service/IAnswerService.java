package com.jason.news.service;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.AnswerDTO;
import com.jason.news.api.dto.AnswerQueryDTO;
import com.jason.news.dao.vo.Answer;

public interface IAnswerService {

    Integer createAnswer(Answer answer);

    Integer deleteAnswer(String answerId);

    PageInfo<AnswerDTO> pageAnswerByParentId(AnswerQueryDTO queryDTO);
}
