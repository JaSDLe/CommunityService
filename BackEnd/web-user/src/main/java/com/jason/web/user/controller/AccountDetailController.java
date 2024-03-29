package com.jason.web.user.controller;

import com.jason.community.api.service.ICommunityService;
import com.jason.member.api.dto.AccountDetailDTO;
import com.jason.member.api.dto.AccountSimpleDTO;
import com.jason.member.api.dto.ReadHistoryDTO;
import com.jason.member.api.enums.AccountTypeEnum;
import com.jason.member.api.enums.ReadHistoryTypeEnum;
import com.jason.member.api.service.IAccountDetailService;
import com.jason.member.api.service.IReadHistoryService;
import com.jason.web.user.dto.ItemResult;
import com.jason.web.user.dto.member.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/accountDetail")
public class AccountDetailController {

    @Autowired
    private IAccountDetailService accountDetailService;

    @Autowired
    private IReadHistoryService readHistoryService;

    @Autowired
    private ICommunityService communityService;

    @GetMapping("/getUserInfoByAccountId")
    public ItemResult<UserInfo> getUserInfoByAccountId(@RequestParam("accountId") String accountId, @RequestParam("operator") String operator) {
        log.info(accountId);
        UserInfo userInfo = new UserInfo();
        AccountSimpleDTO accountSimpleDTO = accountDetailService.findSimpleAccountByAccountId(accountId);
        if (StringUtils.isNotBlank(accountSimpleDTO.getCommunityId())) {
            accountSimpleDTO.setCommunityName(communityService.findByCommunityId(accountSimpleDTO.getCommunityId()).getCommunityName());
        }
        accountSimpleDTO.setTypeText(AccountTypeEnum.getValueByKey(accountSimpleDTO.getType()));
        userInfo.setAccountSimpleDTO(accountSimpleDTO);
        userInfo.setAccountDetailDTO(accountDetailService.findAccountDetailByAccountId(accountId));
        if (!accountId.equals(operator)) {
            readHistoryService.add(new ReadHistoryDTO(ReadHistoryTypeEnum.ACCOUNT.getKey(), operator, accountId));
        }
        return new ItemResult<>(userInfo);
    }

    @PutMapping("/updateAccountDetail")
    public ItemResult<Boolean> updateAccountDetail(@RequestBody AccountDetailDTO accountDetailDTO) {
        if (accountDetailService.updateAccountDetailByAccountId(accountDetailDTO)) {
            return new ItemResult<>(true, "更新成功");
        } else {
            return new ItemResult<>(false, "更新失败");
        }
    }
}
