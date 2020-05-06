package com.jason.activity.api.service;

import com.github.pagehelper.PageInfo;
import com.jason.activity.api.dto.ActivityDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-activity")
public interface IActivityService {

    @RequestMapping(method = RequestMethod.GET, path = "/activity/pageActivity", consumes = "application/json")
    PageInfo<ActivityDTO> pageActivity(@RequestParam(value = "communityId", required = false) String communityId, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @RequestMapping(method = RequestMethod.GET, path = "/activity/findByActivityId", consumes = "application/json")
    ActivityDTO findByActivityId(@RequestParam("activityId") String activityId);
}
