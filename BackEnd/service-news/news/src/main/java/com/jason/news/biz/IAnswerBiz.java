package com.jason.news.biz;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.AnswerDTO;
import com.jason.news.api.dto.AnswerQueryDTO;

public interface IAnswerBiz {

    Boolean createAnswer(AnswerDTO answerDTO);

    Boolean deleteAnswer(String answerId);

    PageInfo<AnswerDTO> pageAnswerByParentId(AnswerQueryDTO queryDTO);
}
