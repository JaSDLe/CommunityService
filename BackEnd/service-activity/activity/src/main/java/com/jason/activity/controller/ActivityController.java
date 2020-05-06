package com.jason.activity.controller;

import com.github.pagehelper.PageInfo;
import com.jason.activity.api.dto.ActivityDTO;
import com.jason.activity.api.dto.ActivityQueryDTO;
import com.jason.activity.biz.IActivityBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private IActivityBiz activityBiz;

    @GetMapping("/pageActivity")
    public PageInfo<ActivityDTO> pageActivity(@RequestParam(value = "communityId", required = false) String communityId,
                                              @RequestParam("pageNum") Integer pageNum,
                                              @RequestParam("pageSize") Integer pageSize) {
        return activityBiz.pageActivity(new ActivityQueryDTO(communityId, pageNum, pageSize));
    }

    @GetMapping("/findByActivityId")
    public ActivityDTO findByActivityId(@RequestParam("activityId") String activityId) {
        return activityBiz.findByActivityId(activityId);
    }
}
