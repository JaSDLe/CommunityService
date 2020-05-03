package com.jason.web.user.dto.community;

import com.jason.community.api.dto.CommunityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunityIndexDTO {

    private List<CommunityDTO> communityDTOList;
}
