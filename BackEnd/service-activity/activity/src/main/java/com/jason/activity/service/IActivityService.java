package com.jason.activity.service;

import com.github.pagehelper.PageInfo;
import com.jason.activity.api.dto.ActivityDTO;
import com.jason.activity.api.dto.ActivityQueryDTO;
import com.jason.activity.dao.vo.Activity;

public interface IActivityService {

    PageInfo<ActivityDTO> pageActivity(ActivityQueryDTO queryDTO);

    Activity findByActivityId(String activityId);

    Integer createActivity(Activity activity);
}
