package com.jason.activity.dao.mapper;

import com.jason.activity.api.dto.ActivityDTO;
import com.jason.activity.api.dto.ActivityQueryDTO;
import com.jason.activity.dao.vo.Activity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ActivityMapper {

    int deleteByPrimaryKey(String activityId);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(String activityId);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

    List<ActivityDTO> findAll(ActivityQueryDTO queryDTO);

    Activity findByActivityId(@Param("activityId") String activityId);
}