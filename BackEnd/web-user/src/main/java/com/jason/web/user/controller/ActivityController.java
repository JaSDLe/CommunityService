package com.jason.web.user.controller;

import com.github.pagehelper.PageInfo;
import com.jason.activity.api.dto.ActivityDTO;
import com.jason.activity.api.service.IActivityService;
import com.jason.web.user.dto.ItemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private IActivityService activityService;

    @GetMapping("/pageActivity")
    public ItemResult<PageInfo<ActivityDTO>> pageActivity(@RequestParam(value = "communityId", required = false) String communityId,
                                                          @RequestParam("pageNum") Integer pageNum,
                                                          @RequestParam("pageSize") Integer pageSize) {
        return new ItemResult<>(activityService.pageActivity(communityId, pageNum, pageSize));
    }

    @GetMapping("/findByActivityId")
    public ItemResult<ActivityDTO> findByActivityId(@RequestParam("activityId") String activityId) {
        return new ItemResult<>(activityService.findByActivityId(activityId));
    }
}
