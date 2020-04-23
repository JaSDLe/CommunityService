package com.jason.member.dao.mapper;

import com.jason.member.dao.vo.AccountDetail;

public interface AccountDetailMapper {

    int deleteByPrimaryKey(String id);

    int insert(AccountDetail record);

    int insertSelective(AccountDetail record);

    AccountDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AccountDetail record);

    int updateByPrimaryKey(AccountDetail record);
}