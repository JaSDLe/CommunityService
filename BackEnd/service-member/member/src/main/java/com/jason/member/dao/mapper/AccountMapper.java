package com.jason.member.dao.mapper;

import com.jason.member.dao.vo.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccountMapper {

    List<Account> findAll();

    Boolean login(@Param("username") String username, @Param("password") String password);

    Boolean isUsernameOnly(@Param("username") String username);

    Account findAccountByUsername(@Param("username") String username);

    Account findAccountByAccountId(@Param("accountId") String accountId);


    int deleteByPrimaryKey(String accountId);

    int insert(Account account);

    int insertSelective(Account account);

    Account selectByPrimaryKey(String accountId);

    int updateByPrimaryKeySelective(Account account);

    int updateByPrimaryKey(Account account);

    List<Account> findAdminListByCommunityId(@Param("communityId") String communityId, @Param("type") Integer type);

    Integer findPopulationByCommunityId(@Param("communityId") String communityId, @Param("type") Integer type);

    Integer joinCommunity(@Param("accountId") String accountId, @Param("communityId") String communityId, @Param("type") Integer type);

    Integer updateAccountBaseInfo(Account account);

    Integer becomeAdmin(@Param("accountId") String accountId, @Param("type") Integer type);
}
