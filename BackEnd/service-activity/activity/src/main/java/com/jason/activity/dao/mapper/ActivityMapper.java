package com.jason.activity.dao.mapper;


import com.jason.activity.dao.vo.Activity;

public interface ActivityMapper {

    int deleteByPrimaryKey(String activityId);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(String activityId);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
}