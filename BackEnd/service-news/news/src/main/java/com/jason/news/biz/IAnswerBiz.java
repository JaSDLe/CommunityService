package com.jason.news.biz;

import com.github.pagehelper.PageInfo;
import com.jason.news.api.dto.AnswerDTO;
import com.jason.news.api.dto.AnswerQueryDTO;
import com.jason.news.api.dto.NoticeDTO;
import com.jason.news.api.dto.NoticeQueryDTO;

public interface IAnswerBiz {

    Boolean createAnswer(AnswerDTO answerDTO);

    Boolean deleteAnswer(String answerId);

    PageInfo<AnswerDTO> pageAnswerByParentId(AnswerQueryDTO queryDTO);
}
