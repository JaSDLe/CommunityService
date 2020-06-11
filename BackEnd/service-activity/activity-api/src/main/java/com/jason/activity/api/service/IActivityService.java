package com.jason.activity.api.service;

import com.github.pagehelper.PageInfo;
import com.jason.activity.api.dto.ActivityDTO;
import com.jason.activity.api.dto.ActivityQueryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-activity")
public interface IActivityService {

    @RequestMapping(method = RequestMethod.POST, path = "/activity/pageActivity", consumes = "application/json")
    PageInfo<ActivityDTO> pageActivity(@RequestBody ActivityQueryDTO queryDTO);

    @RequestMapping(method = RequestMethod.GET, path = "/activity/findByActivityId", consumes = "application/json")
    ActivityDTO findByActivityId(@RequestParam("activityId") String activityId);

    @RequestMapping(method = RequestMethod.GET, path = "/activity/createActivity", consumes = "application/json")
    Boolean createActivity(@RequestBody ActivityDTO activityDTO);
}
