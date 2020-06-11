package com.jason.activity.controller;

import com.github.pagehelper.PageInfo;
import com.jason.activity.api.dto.ActivityDTO;
import com.jason.activity.api.dto.ActivityQueryDTO;
import com.jason.activity.biz.IActivityBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private IActivityBiz activityBiz;

    @PostMapping("/pageActivity")
    public PageInfo<ActivityDTO> pageActivity(@RequestBody ActivityQueryDTO queryDTO) {
        return activityBiz.pageActivity(queryDTO);
    }

    @GetMapping("/findByActivityId")
    public ActivityDTO findByActivityId(@RequestParam("activityId") String activityId) {
        return activityBiz.findByActivityId(activityId);
    }

    @PostMapping("/createActivity")
    public Boolean createActivity(@RequestBody ActivityDTO activityDTO) {
        return activityBiz.createActivity(activityDTO);
    }
}
