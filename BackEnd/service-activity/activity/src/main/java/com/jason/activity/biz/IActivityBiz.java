package com.jason.activity.biz;

import com.github.pagehelper.PageInfo;
import com.jason.activity.api.dto.ActivityDTO;
import com.jason.activity.api.dto.ActivityQueryDTO;

public interface IActivityBiz {

    PageInfo<ActivityDTO> pageActivity(ActivityQueryDTO queryDTO);

    ActivityDTO findByActivityId(String activityId);

    Boolean createActivity(ActivityDTO activityDTO);
}
