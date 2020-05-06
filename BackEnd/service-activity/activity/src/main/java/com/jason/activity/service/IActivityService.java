package com.jason.activity.service;

import com.jason.activity.api.dto.ActivityQueryDTO;
import com.jason.activity.dao.vo.Activity;

import java.util.List;

public interface IActivityService {

    List<Activity> pageActivity(ActivityQueryDTO queryDTO);

    Activity findByActivityId(String activityId);
}
