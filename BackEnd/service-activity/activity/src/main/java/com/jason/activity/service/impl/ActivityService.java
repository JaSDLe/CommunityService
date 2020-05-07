package com.jason.activity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.activity.api.dto.ActivityDTO;
import com.jason.activity.api.dto.ActivityQueryDTO;
import com.jason.activity.dao.mapper.ActivityMapper;
import com.jason.activity.dao.vo.Activity;
import com.jason.activity.service.IActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ActivityService implements IActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public PageInfo<ActivityDTO> pageActivity(ActivityQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        return PageInfo.of(activityMapper.findAll(queryDTO.getCommunityId()));
    }

    @Override
    public Activity findByActivityId(String activityId) {
        return activityMapper.findByActivityId(activityId);
    }
}
