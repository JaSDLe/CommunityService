package com.jason.activity.biz.impl;

import com.github.pagehelper.PageInfo;
import com.jason.activity.api.dto.ActivityDTO;
import com.jason.activity.api.dto.ActivityQueryDTO;
import com.jason.activity.biz.IActivityBiz;
import com.jason.activity.dao.vo.Activity;
import com.jason.activity.service.IActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
public class ActivityBiz implements IActivityBiz {

    @Autowired
    private IActivityService activityService;

    public PageInfo<ActivityDTO> pageActivity(ActivityQueryDTO queryDTO) {
        return PageInfo.of(activityService.pageActivity(queryDTO).stream().map(this::vO2DTO).collect(Collectors.toList()));
    }

    @Override
    public ActivityDTO findByActivityId(String activityId) {
        return vO2DTO(activityService.findByActivityId(activityId));
    }

    private ActivityDTO vO2DTO(Activity activity) {
        if (activity == null) {
            return null;
        }
        ActivityDTO activityDTO = new ActivityDTO();
        BeanUtils.copyProperties(activity, activityDTO);
        return activityDTO;
    }
}
