package com.jason.member.dao.mapper;

import com.jason.member.dao.vo.AccountDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface AccountDetailMapper {

    int deleteByPrimaryKey(String id);

    int insert(AccountDetail record);

    int insertSelective(AccountDetail record);

    AccountDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AccountDetail record);

    int updateByPrimaryKey(AccountDetail record);

    AccountDetail findAccountDetailByAccountId(@Param("accountId") String accountId);

    int updateAccountDetailByAccountId(@Param("accountDetail") AccountDetail accountDetail);
}