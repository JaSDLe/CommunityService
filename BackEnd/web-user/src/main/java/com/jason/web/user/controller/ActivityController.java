package com.jason.web.user.controller;

import com.github.pagehelper.PageInfo;
import com.jason.activity.api.dto.ActivityDTO;
import com.jason.activity.api.service.IActivityService;
import com.jason.member.api.dto.ReadHistoryDTO;
import com.jason.member.api.enums.ReadHistoryTypeEnum;
import com.jason.member.api.service.IAccountDetailService;
import com.jason.member.api.service.IReadHistoryService;
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

    @Autowired
    private IReadHistoryService readHistoryService;

    @Autowired
    private IAccountDetailService accountDetailService;

    @GetMapping("/pageActivity")
    public ItemResult<PageInfo<ActivityDTO>> pageActivity(@RequestParam(value = "communityId", required = false) String communityId,
                                                          @RequestParam("pageNum") Integer pageNum,
                                                          @RequestParam("pageSize") Integer pageSize) {
        PageInfo<ActivityDTO> result = activityService.pageActivity(communityId, pageNum, pageSize);
        result.getList().forEach(i -> {
            if (i != null) {
                i.setNickname(accountDetailService.findSimpleAccountByAccountId(i.getCreateUser()).getNickname());
            }
        });
        return new ItemResult<>(result);
    }

    @GetMapping("/findByActivityId")
    public ItemResult<ActivityDTO> findByActivityId(@RequestParam("activityId") String activityId, @RequestParam("operator") String operator) {
        ActivityDTO result = activityService.findByActivityId(activityId);
        if (result != null) {
            result.setNickname(accountDetailService.findSimpleAccountByAccountId(result.getCreateUser()).getNickname());
            readHistoryService.add(new ReadHistoryDTO(ReadHistoryTypeEnum.ACTIVITY.getKey(), operator, activityId));
        }
        return new ItemResult<>(result);
    }
}
