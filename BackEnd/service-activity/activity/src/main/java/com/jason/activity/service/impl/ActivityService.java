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

import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class ActivityService implements IActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public PageInfo<ActivityDTO> pageActivity(ActivityQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        return PageInfo.of(activityMapper.findAll(queryDTO));
    }

    @Override
    public Activity findByActivityId(String activityId) {
        return activityMapper.findByActivityId(activityId);
    }

    @Override
    public Integer createActivity(Activity activity) {
        activity.setActivityId(UUID.randomUUID().toString().replace("-", ""));
        activity.setReplyNum(0);
        activity.setDelFlg(Boolean.FALSE);
        activity.setCreateTime(new Date());
        activity.setUpdateUser(activity.getCreateUser());
        activity.setUpdateTime(new Date());
        return activityMapper.insert(activity);
    }
}
