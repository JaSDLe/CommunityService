package com.jason.activity.service.impl;

import com.github.pagehelper.PageHelper;
import com.jason.activity.api.dto.ActivityQueryDTO;
import com.jason.activity.dao.mapper.ActivityMapper;
import com.jason.activity.dao.vo.Activity;
import com.jason.activity.service.IActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ActivityService implements IActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public List<Activity> pageActivity(ActivityQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        return activityMapper.findAll(queryDTO.getCommunityId());
    }

    @Override
    public Activity findByActivityId(String activityId) {
        return activityMapper.findByActivityId(activityId);
    }
}
